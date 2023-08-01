package PhoneBook;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;



public class PhoneBook {
	
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        PhoneBook phoneBook = new PhoneBook();
        String stroka;
        while (true) {
            System.out.print("Введите номер, имя, команду LIST (STOP, чтобы выйти): ");
            stroka = input.next();
            System.out.println();

            if (stroka.equals("LIST")) {
                for (String contact : phoneBook.getAllContacts()) {
                    System.out.println(contact);
                }
            } else if (stroka.equals("STOP")) {
                break;
            } else if (phoneBook.isNumber(stroka)) {
                if (phoneBook.getNameByPhone(stroka).isEmpty()) {
                    System.out.println(
                            "Такого номера нет в телефонной книге.\n Введите имя для абонента \"" + stroka + "\": ");
                    String name = input.next();
                    phoneBook.addContact(stroka, name);
                    System.out.println("Контакт сохранён");
                } else {
                    System.out.println(phoneBook.getNameByPhone(stroka));
                }
            } else if (!phoneBook.isNumber(stroka)) {
                if (phoneBook.getPhonesByName(stroka).isEmpty()) {
                    System.out.println(
                            "Такого имени в телефонной книге нет.\nВведите номер телефона для абонента \"" + stroka + "\": ");
                    while (true) {
                        String phone = input.next();
                        System.out.println();
                        if (phoneBook.isNumber(phone)) {
                            phoneBook.addContact(phone, stroka);
                            System.out.println("Контакт сохранён");
                            break;
                        } else {
                            System.out.print("Неверный формат номера, введите снова: ");
                        }
                    }

                } else {
                    String namePhones = stroka + " - ";
                    for (String phone : phoneBook.getPhonesByName(stroka)) {
                        namePhones += phone + ", ";
                    }
                    System.out.println(namePhones.substring(0, namePhones.length() - 2));
                }
            }

        }

    }

    HashMap<String, String> book = new HashMap<>();

    public void addContact(String phone, String name) {
        // TODO проверьте корректность формата имени и телефона
        // если такой номер уже есть в списке, то перезаписать имя абонента

        if (isCorrect(name, phone)) {
            boolean phoneInBook = false;
            for (String bookPhone : book.keySet()) {
                if (bookPhone.equals(phone)) {
                    book.replace(bookPhone, name);
                    phoneInBook = true;
                }
            }
            if (!phoneInBook) {
                book.put(phone, name);
            }
        }

    }

    public String getNameByPhone(String phone) {
        // TODO формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку

        for (String bookPhone : book.keySet()) {
            if (bookPhone.equals(phone)) {
                return book.get(bookPhone);
            }
        } 
        return "";
    }

    public Set<String> getPhonesByName(String name) {
        Set<String> phones = new HashSet<>();

        for (String bookPhone : book.keySet()) {
            if ((book.get(bookPhone)).equals(name)) {
                phones.add(bookPhone);
            }
        }

        return phones;
    }

    public StringBuilder getNumbersToString(Set<String> numbers) {
        // TODO вернуть номера в формате строки <номер>, <номер>.
        StringBuilder stringNumbers = new StringBuilder();
        for (String number : numbers) {
            stringNumbers.append(number + ",");
        }

        String abc = stringNumbers.substring(0, stringNumbers.length()-2);
        stringNumbers = new StringBuilder(abc);
        return stringNumbers;
    }

    public Set<String> getAllContacts() {
        // TODO вернуть все контакты в формате <имя> — <номер>, <номер> и тд
        Set<String> names = new TreeSet<>();
        Set<String> allContacts = new HashSet<>();

        for (String name : book.values()) {
            names.add(name);
        }

        for (String bookName : names) {
            String namePhones = bookName + " - ";
            for (String bookPhone : book.keySet()) {
                if (bookName.equals(book.get(bookPhone))) {
                    namePhones += bookPhone + ", ";
                }
            }
            allContacts.add(namePhones.substring(0 ,namePhones.length() - 2));
        }

        return allContacts;
    }

    public boolean checkContacts(String name) {
        // TODO проверьте корректность формата имени и телефона
        // если такой номер уже есть в списке, то перезаписать имя абонента

        boolean nameInBook = false;

        for (String bookName : book.values()) {
            if (bookName.equals(name)) {
                nameInBook = true;
            }
        }

        return nameInBook;
    }

    public boolean isCorrect(String name, String phone) {
        if (phone.length() == 11 && phone.matches("\\d+")) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isNumber(String phone) {
        if (phone.length() == 11 && phone.matches("\\d+")) {
            return true;
        } else {
            return false;
        }
    }

}

