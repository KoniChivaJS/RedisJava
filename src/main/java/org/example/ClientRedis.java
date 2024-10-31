package org.example;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Jedis;

import java.util.Scanner;

public class ClientRedis {
    private static JedisPool jedisPool;

    public ClientRedis(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    static public void create() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть id client: ");
        String id = scanner.nextLine();
        System.out.print("Введіть name client: ");
        String name = scanner.nextLine();
        System.out.print("Введіть surname client: ");
        String surname = scanner.nextLine();
        System.out.print("Введіть contact_info client: ");
        String contact_info = scanner.nextLine();

        try (Jedis jedis = jedisPool.getResource()) {
            String key = "client:" + id;
            jedis.hset(key, "id", id);
            jedis.hset(key, "name", name);
            jedis.hset(key, "surname", surname);
            jedis.hset(key, "contact_info", contact_info);
            System.out.println("Client created: " + key);
        }
    }

    static public void read() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть id client: ");
        String id = scanner.nextLine();
        try (Jedis jedis = jedisPool.getResource()) {
            String key = "client:" + id;
            System.out.println("Client data: " + jedis.hgetAll(key));
        }
    }

    static public void update() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть id client: ");
        String id = scanner.nextLine();
        System.out.print("Введіть field client: ");
        String field = scanner.nextLine();
        System.out.print("Введіть new value client: ");
        String newValue = scanner.nextLine();

        try (Jedis jedis = jedisPool.getResource()) {
            String key = "client:" + id;
            jedis.hset(key, field, newValue);
            System.out.println("Client updated: " + key + ", field: " + field + " = " + newValue);
        }
    }

    static public void delete() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть id client: ");
        String id = scanner.nextLine();
        try (Jedis jedis = jedisPool.getResource()) {
            String key = "client:" + id;
            jedis.del(key);
            System.out.println("Client deleted: " + key);
        }
    }
}
