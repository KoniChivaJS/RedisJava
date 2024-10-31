package org.example;

import java.util.Scanner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Main {
    public static void main(String[] args) {
        JedisPool jedisPool = new JedisPool("localhost", 6379);
        ClientRedis clientService = new ClientRedis(jedisPool);
        AgentRedis insuranceAgentService = new AgentRedis(jedisPool);
        CompanyRedis companyService = new CompanyRedis(jedisPool);
        PaymentRedis paymentService = new PaymentRedis(jedisPool);
        InsuranceRedis insuranceService = new InsuranceRedis(jedisPool);
        PolicyRedis policyService = new PolicyRedis(jedisPool);
        boolean programWorking = true;
        while (programWorking) {
            Scanner scanner = new Scanner(System.in);
            Integer option;
            System.out.println("Виберіть опцію: ");
            System.out.println("(1) Таблиця Client: ");
            System.out.println("(2) Таблиця insurance_agent: ");
            System.out.println("(3) Таблиця insurance_company: ");
            System.out.println("(4) Таблиця insurance_type: ");
            System.out.println("(5) Таблиця payment: ");
            System.out.println("(6) Таблиця insurance_policy: ");
            System.out.println("(7) Вихід: ");
            option = scanner.nextInt();

            switch (option){
                case 1:
                    clientMenu(clientService);
                    break;
                case 2:
                    InsuranceAgentMenu(insuranceAgentService);
                    break;
                case 3:
                    CompanyMenu(companyService);
                    break;
                case 4:
                    PaymentMenu(paymentService);
                    break;
                case 5:
                    InsuranceMenu(insuranceService);
                    break;
                case 6:
                    PolicyMenu(policyService);
                    break;
                case 7:
                    programWorking = false;
                    break;
                default:
                    System.out.println("Не існує такої опції!");
                    break;
            }

        }

    }
    public static void clientMenu(ClientRedis clientService) {
        Scanner scanner = new Scanner(System.in);
        Integer option;
        System.out.println("CLIENT опції: ");
        System.out.println("(1) Додати клієнта: ");
        System.out.println("(2) Отримати клієнта: ");
        System.out.println("(3) Оновити клієнта: ");
        System.out.println("(4) Видалити клієнта: ");
        System.out.println("(5) Повернутись назад: ");
        option = scanner.nextInt();
        switch (option){
            case 1:
                clientService.create();
                break;
            case 2:
                clientService.read();
                break;
            case 3:
                clientService.update();
                break;
            case 4:
                clientService.delete();
                break;
            case 5:
                System.out.println(".......");
                break;
            default:
                System.out.println("Не існує такої опції!");
                break;

        }
    }

    public static void InsuranceAgentMenu(AgentRedis insuranceAgentService) {
        Scanner scanner = new Scanner(System.in);
        Integer option;
        System.out.println("AGENT опції: ");
        System.out.println("(1) Додати агента: ");
        System.out.println("(2) Отримати агента: ");
        System.out.println("(3) Оновити агента: ");
        System.out.println("(4) Видалити агента: ");
        System.out.println("(5) Повернутись назад: ");
        option = scanner.nextInt();
        switch (option){
            case 1:
                insuranceAgentService.create();
                break;
            case 2:
                insuranceAgentService.read();
                break;
            case 3:
                insuranceAgentService.update();
                break;
            case 4:
                insuranceAgentService.delete();
                break;
            case 5:
                System.out.println(".......");
                break;
            default:
                System.out.println("Не існує такої опції!");
                break;

        }
    }

    public static void CompanyMenu(CompanyRedis service) {
        Scanner scanner = new Scanner(System.in);
        Integer option;
        System.out.println("COMPANY опції: ");
        System.out.println("(1) Додати компанію: ");
        System.out.println("(2) Отримати компанію: ");
        System.out.println("(3) Оновити компанію: ");
        System.out.println("(4) Видалити компанію: ");
        System.out.println("(5) Повернутись назад: ");
        option = scanner.nextInt();
        switch (option){
            case 1:
                service.create();
                break;
            case 2:
                service.read();
                break;
            case 3:
                service.update();
                break;
            case 4:
                service.delete();
                break;
            case 5:
                System.out.println(".......");
                break;
            default:
                System.out.println("Не існує такої опції!");
                break;

        }
    }

    public static void PaymentMenu(PaymentRedis service) {
        Scanner scanner = new Scanner(System.in);
        Integer option;
        System.out.println("PAYMENT опції: ");
        System.out.println("(1) Додати оплату: ");
        System.out.println("(2) Отримати оплату: ");
        System.out.println("(3) Оновити оплату: ");
        System.out.println("(4) Видалити оплату: ");
        System.out.println("(5) Повернутись назад: ");
        option = scanner.nextInt();
        switch (option){
            case 1:
                service.create();
                break;
            case 2:
                service.read();
                break;
            case 3:
                service.update();
                break;
            case 4:
                service.delete();
                break;
            case 5:
                System.out.println(".......");
                break;
            default:
                System.out.println("Не існує такої опції!");
                break;

        }
    }

    public static void InsuranceMenu(InsuranceRedis service) {
        Scanner scanner = new Scanner(System.in);
        Integer option;
        System.out.println("type опції: ");
        System.out.println("(1) Додати type: ");
        System.out.println("(2) Отримати type: ");
        System.out.println("(3) Оновити type: ");
        System.out.println("(4) Видалити type: ");
        System.out.println("(5) Повернутись назад: ");
        option = scanner.nextInt();
        switch (option){
            case 1:
                service.create();
                break;
            case 2:
                service.read();
                break;
            case 3:
                service.update();
                break;
            case 4:
                service.delete();
                break;
            case 5:
                System.out.println(".......");
                break;
            default:
                System.out.println("Не існує такої опції!");
                break;

        }
    }

    public static void PolicyMenu(PolicyRedis service) {
        Scanner scanner = new Scanner(System.in);
        Integer option;
        System.out.println("policy опції: ");
        System.out.println("(1) Додати policy: ");
        System.out.println("(2) Отримати policy: ");
        System.out.println("(3) Оновити policy: ");
        System.out.println("(4) Видалити policy: ");
        System.out.println("(5) Повернутись назад: ");
        option = scanner.nextInt();
        switch (option){
            case 1:
                service.create();
                break;
            case 2:
                service.read();
                break;
            case 3:
                service.update();
                break;
            case 4:
                service.delete();
                break;
            case 5:
                System.out.println(".......");
                break;
            default:
                System.out.println("Не існує такої опції!");
                break;

        }
    }
}