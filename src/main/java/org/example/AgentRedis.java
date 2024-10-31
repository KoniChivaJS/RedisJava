package org.example;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Scanner;

public class AgentRedis {
    private static JedisPool jedisPool;

    public AgentRedis(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    static public void create() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть id agent: ");
        String id = scanner.nextLine();
        System.out.print("Введіть name agent: ");
        String name = scanner.nextLine();
        System.out.print("Введіть surname agent: ");
        String surname = scanner.nextLine();
        System.out.print("Введіть contact_info agent: ");
        String contact_info = scanner.nextLine();
        System.out.print("Введіть company_id agent: ");
        String company_id = scanner.nextLine();

        try (Jedis jedis = jedisPool.getResource()) {
            String key = "insurance_agent:" + id;
            jedis.hset(key, "id", id);
            jedis.hset(key, "name", name);
            jedis.hset(key, "surname", surname);
            jedis.hset(key, "contact_info", contact_info);
            jedis.hset(key, "company_id", company_id);
            System.out.println("Agent created: " + key);
        }
    }

    static public void read() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть id agent: ");
        String id = scanner.nextLine();
        try (Jedis jedis = jedisPool.getResource()) {
            String key = "insurance_agent:" + id;
            System.out.println("agent data: " + jedis.hgetAll(key));
        }
    }

    static public void update() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть id agent: ");
        String id = scanner.nextLine();
        System.out.print("Введіть field agent: ");
        String field = scanner.nextLine();
        System.out.print("Введіть new value agent: ");
        String newValue = scanner.nextLine();

        try (Jedis jedis = jedisPool.getResource()) {
            String key = "insurance_agent:" + id;
            jedis.hset(key, field, newValue);
            System.out.println("agent updated: " + key + ", field: " + field + " = " + newValue);
        }
    }

    static public void delete() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть id agent: ");
        String id = scanner.nextLine();
        try (Jedis jedis = jedisPool.getResource()) {
            String key = "insurance_agent:" + id;
            jedis.del(key);
            System.out.println("agent deleted: " + key);
        }
    }
}
