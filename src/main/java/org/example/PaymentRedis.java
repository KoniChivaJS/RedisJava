package org.example;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Scanner;

public class PaymentRedis {
    private static JedisPool jedisPool;

    public PaymentRedis(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    static public void create() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть id company: ");
        String id = scanner.nextLine();
        System.out.print("Введіть policy_id company: ");
        String policy_id = scanner.nextLine();
        System.out.print("Введіть payment_date company: ");
        String payment_date = scanner.nextLine();
        System.out.print("Введіть amount company: ");
        String amount = scanner.nextLine();

        try (Jedis jedis = jedisPool.getResource()) {
            String key = "payment:" + id;
            jedis.hset(key, "id", id);
            jedis.hset(key, "policy_id", policy_id);
            jedis.hset(key, "payment_date", payment_date);
            jedis.hset(key, "amount", amount);
            System.out.println("payment created: " + key);
        }
    }

    static public void read() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть id payment: ");
        String id = scanner.nextLine();
        try (Jedis jedis = jedisPool.getResource()) {
            String key = "payment:" + id;
            System.out.println("payment data: " + jedis.hgetAll(key));
        }
    }

    static public void update() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть id payment: ");
        String id = scanner.nextLine();
        System.out.print("Введіть field payment: ");
        String field = scanner.nextLine();
        System.out.print("Введіть new value payment: ");
        String newValue = scanner.nextLine();

        try (Jedis jedis = jedisPool.getResource()) {
            String key = "payment:" + id;
            jedis.hset(key, field, newValue);
            System.out.println("payment updated: " + key + ", field: " + field + " = " + newValue);
        }
    }

    static public void delete() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть id payment: ");
        String id = scanner.nextLine();
        try (Jedis jedis = jedisPool.getResource()) {
            String key = "payment:" + id;
            jedis.del(key);
            System.out.println("payment deleted: " + key);
        }
    }
}
