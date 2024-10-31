package org.example;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Scanner;

public class InsuranceRedis {
    private static JedisPool jedisPool;

    public InsuranceRedis(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    static public void create() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть id type: ");
        String id = scanner.nextLine();
        System.out.print("Введіть name type: ");
        String name = scanner.nextLine();
        System.out.print("Введіть description type: ");
        String description = scanner.nextLine();

        try (Jedis jedis = jedisPool.getResource()) {
            String key = "insurance_type:" + id;
            jedis.hset(key, "id", id);
            jedis.hset(key, "name", name);
            jedis.hset(key, "description", description);
            System.out.println("type created: " + key);
        }
    }

    static public void read() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть id insurance_type: ");
        String id = scanner.nextLine();
        try (Jedis jedis = jedisPool.getResource()) {
            String key = "insurance_type:" + id;
            System.out.println("type data: " + jedis.hgetAll(key));
        }
    }

    static public void update() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть id type: ");
        String id = scanner.nextLine();
        System.out.print("Введіть field payment: ");
        String field = scanner.nextLine();
        System.out.print("Введіть new value payment: ");
        String newValue = scanner.nextLine();

        try (Jedis jedis = jedisPool.getResource()) {
            String key = "insurance_type:" + id;
            jedis.hset(key, field, newValue);
            System.out.println("insurance_type updated: " + key + ", field: " + field + " = " + newValue);
        }
    }

    static public void delete() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть id type: ");
        String id = scanner.nextLine();
        try (Jedis jedis = jedisPool.getResource()) {
            String key = "insurance_type:" + id;
            jedis.del(key);
            System.out.println("insurance_type deleted: " + key);
        }
    }
}
