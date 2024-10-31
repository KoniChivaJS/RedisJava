package org.example;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Scanner;

public class CompanyRedis {
    private static JedisPool jedisPool;

    public CompanyRedis(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    static public void create() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть id company: ");
        String id = scanner.nextLine();
        System.out.print("Введіть name company: ");
        String name = scanner.nextLine();
        System.out.print("Введіть address company: ");
        String address = scanner.nextLine();
        System.out.print("Введіть contact_info company: ");
        String contact_info = scanner.nextLine();

        try (Jedis jedis = jedisPool.getResource()) {
            String key = "insurance_company:" + id;
            jedis.hset(key, "id", id);
            jedis.hset(key, "name", name);
            jedis.hset(key, "address", address);
            jedis.hset(key, "contact_info", contact_info);
            System.out.println("Agent created: " + key);
        }
    }

    static public void read() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть id company: ");
        String id = scanner.nextLine();
        try (Jedis jedis = jedisPool.getResource()) {
            String key = "insurance_company:" + id;
            System.out.println("agent data: " + jedis.hgetAll(key));
        }
    }

    static public void update() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть id company: ");
        String id = scanner.nextLine();
        System.out.print("Введіть field company: ");
        String field = scanner.nextLine();
        System.out.print("Введіть new value company: ");
        String newValue = scanner.nextLine();

        try (Jedis jedis = jedisPool.getResource()) {
            String key = "insurance_company:" + id;
            jedis.hset(key, field, newValue);
            System.out.println("company updated: " + key + ", field: " + field + " = " + newValue);
        }
    }

    static public void delete() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть id company: ");
        String id = scanner.nextLine();
        try (Jedis jedis = jedisPool.getResource()) {
            String key = "insurance_company:" + id;
            jedis.del(key);
            System.out.println("company deleted: " + key);
        }
    }
}
