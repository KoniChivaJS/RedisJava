package org.example;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Scanner;

public class PolicyRedis {
    private static JedisPool jedisPool;

    public PolicyRedis(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    static public void create() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть id policy: ");
        String id = scanner.nextLine();
        System.out.print("Введіть client_id policy: ");
        String client_id = scanner.nextLine();
        System.out.print("Введіть agent_id policy: ");
        String agent_id = scanner.nextLine();
        System.out.print("Введіть type_id policy: ");
        String type_id = scanner.nextLine();
        System.out.print("Введіть cost policy: ");
        String cost = scanner.nextLine();
        System.out.print("Введіть term policy: ");
        String term = scanner.nextLine();
        System.out.print("Введіть company_id policy: ");
        String company_id = scanner.nextLine();
        System.out.print("Введіть commission policy: ");
        String commission = scanner.nextLine();
        System.out.print("Введіть payment_id policy: ");
        String payment_id = scanner.nextLine();

        try (Jedis jedis = jedisPool.getResource()) {
            String key = "insurance_policy:" + id;
            jedis.hset(key, "id", id);
            jedis.hset(key, "client_id", client_id);
            jedis.hset(key, "agent_id", agent_id);
            jedis.hset(key, "type_id", type_id);
            jedis.hset(key, "cost", cost);
            jedis.hset(key, "term", term);
            jedis.hset(key, "company_id", company_id);
            jedis.hset(key, "commission", commission);
            jedis.hset(key, "payment_id", payment_id);
            System.out.println("Agent created: " + key);
        }
    }

    static public void read() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть id policy: ");
        String id = scanner.nextLine();
        try (Jedis jedis = jedisPool.getResource()) {
            String key = "insurance_policy:" + id;
            System.out.println("insurance_policy data: " + jedis.hgetAll(key));
        }
    }

    static public void update() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть id policy: ");
        String id = scanner.nextLine();
        System.out.print("Введіть field policy: ");
        String field = scanner.nextLine();
        System.out.print("Введіть new value policy: ");
        String newValue = scanner.nextLine();

        try (Jedis jedis = jedisPool.getResource()) {
            String key = "insurance_policy:" + id;
            jedis.hset(key, field, newValue);
            System.out.println("insurance_policy updated: " + key + ", field: " + field + " = " + newValue);
        }
    }

    static public void delete() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть id policy: ");
        String id = scanner.nextLine();
        try (Jedis jedis = jedisPool.getResource()) {
            String key = "insurance_policy:" + id;
            jedis.del(key);
            System.out.println("policy deleted: " + key);
        }
    }
}
