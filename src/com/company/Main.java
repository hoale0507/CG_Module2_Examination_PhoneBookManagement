package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static TelephoneDirectoryManagement telephoneDirectoryManagement = new TelephoneDirectoryManagement();
    public static EmailRegexPattern emailRegexPattern = new EmailRegexPattern();
    public static PhoneRegexPattern phoneRegexPattern = new PhoneRegexPattern();

    public static void main(String[] args) {
        File file = new File("directory.txt");
        if(file.exists()){
            try {
                telephoneDirectoryManagement.setTelephoneDirectories(readFile("directory.txt"));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        int choice = -1;
        do {
            menu();
            choice = input.nextInt();
            input.nextLine();
            switch(choice){
                case 1: {
                    if(telephoneDirectoryManagement.size()== 0) {
                        System.out.println("Danh bạ trống!");
                    } else{
                        telephoneDirectoryManagement.displayAllDirectory();
                    }
                    break;
                }
                case 2: {
                    addDirectory();
                    System.out.println("Thêm danh bạ mới thành công");
                    break;
                }
                case 3: {
                    System.out.println("Cập nhật danh bạ:");
                    System.out.println("Nhập số điện thoại cần cập nhật:");
                    String phoneNumber = input.nextLine();
                    if(!telephoneDirectoryManagement.isExitedPhoneNumber(phoneNumber)){
                        System.out.println("Không tìm được danh bạ với số điện thoại trên.");
                    } else {
                        System.out.println("Nhập nhóm của danh bạ:");
                        String group = input.nextLine();
                        System.out.println("Nhập họ tên:");
                        String name = input.nextLine();
                        System.out.println("Nhập giới tính:");
                        String gender = input.nextLine();
                        System.out.println("Nhập địa chỉ:");
                        String address = input.nextLine();
                        System.out.println("Nhập ngày sinh:");
                        String dateOfBirth = input.nextLine();
                        String email = "";
                        do{
                            System.out.println("Nhập email:");
                            System.out.println("Lưu ý nhập đúng định dạng email");
                            email = input.nextLine();
                        } while (!emailRegexPattern.validate(email));
//                        System.out.println("Nhập email");
//                        String email = input.nextLine();
                        telephoneDirectoryManagement.update(phoneNumber, group, name, gender, address, dateOfBirth, email);
                        System.out.println("Cập nhật thông tin thành công!");
                    }
                    break;
                }
                case 4: {
                    System.out.println("Xoá thông tin danh bạ:");
                    System.out.println("Nhập số điện thoại cần xoá:");
                    String phoneNumber = input.nextLine();
                    if(telephoneDirectoryManagement.isExitedPhoneNumber(phoneNumber)){
                        System.out.println("Chọn \'Y\' để xác nhật hoặc chọn phím khác để thoát ");
                        String choiceY = input.nextLine();
                        if(choiceY.equals("Y")){
                            telephoneDirectoryManagement.delete(phoneNumber);
                        }
                    } else {
                        System.out.println("Không tìm được danh bạ với số điện thoại trên.");
                    }
                break;
                }

                case 5:
                    int choiceSearch = -1;
                    do {
                        System.out.println("Tìm kiếm thông tin theo số điện thoại hoặc họ tên:");
                        System.out.println("1. Tìm kiếm theo số điện thoại");
                        System.out.println("2. Tìm kiếm theo họ tên");
                        System.out.println("0. Quay lại");
                        choiceSearch = input.nextInt();
                        switch (choiceSearch){
                            case 1: {
                                System.out.println("Nhập số điện thoại cần tìm:");
                                String phoneNumber = input.nextLine();
                                if(telephoneDirectoryManagement.isExitedPhoneNumber(phoneNumber)){
                                    System.out.println(telephoneDirectoryManagement.searchByPhone(phoneNumber));
                                } else {
                                    System.out.println("Không tìm thấy số điện thoại");
                                }
                                break;
                            }
                            case 2: {
                                System.out.println("Nhập tên cần tìm:");
                                String name = input.nextLine();
                                if(telephoneDirectoryManagement.indexFoundByName(name) != -1){
                                    System.out.println(telephoneDirectoryManagement.searchByName(name));
                                } else {
                                    System.out.println("Không tìm thấy tên");
                                }
                                break;
                            }
                        }
                    } while(choiceSearch != 0);
                    break;
                case 6: {
                    System.out.println("Đọc từ file");
                    break;
                }
                case 7: {
                    System.out.println("Ghi vào file");
                    try {
                        writeToFileCSV("directoryCSV.txt");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            try {
                writeToFile("directory.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (choice != 8);
    }

    private static void addDirectory() {
        System.out.println("Thêm danh bạ mới: ");
        String phoneNumber = "";
//        do {
//            System.out.println("Nhập số điện thoại:");
//            System.out.println("Lưu ý nhập đúng định dạng!");
//            phoneNumber = input.nextLine();
//        } while(!phoneRegexPattern.validate(phoneNumber));

        System.out.println("Nhập số điện thoại:");
        System.out.println("Lưu ý nhập đúng định dạng!");
        phoneNumber = input.nextLine();

        System.out.println("Nhập nhóm của danh bạ");
        String group = input.nextLine();
        System.out.println("Nhập họ tên:");
        String name = input.nextLine();
        System.out.println("Nhập giới tính:");
        String gender = input.nextLine();
        System.out.println("Nhập địa chỉ:");
        String address = input.nextLine();
        System.out.println("Nhập ngày sinh:");
        String dateOfBirth = input.nextLine();
        String email = "";
        do{
            System.out.println("Nhập email:");
            System.out.println("Lưu ý nhập đúng định dạng email");
            email = input.nextLine();
        } while (!emailRegexPattern.validate(email));
        TelephoneDirectory telephoneDirectory = new TelephoneDirectory(phoneNumber, group, name, gender,address, dateOfBirth, email);
        telephoneDirectoryManagement.add(telephoneDirectory);
    }

    private static void menu() {
        System.out.println("---CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ");
        System.out.println("Chọn chức năng theo số để tiếp tục:");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xoá");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("8. Thoát");
        System.out.println("Chọn chức năng: ");
    }

    public static void writeToFile(String path) throws IOException {
        OutputStream os = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(telephoneDirectoryManagement.getTelephoneDirectories());
        oos.close();
        os.close();
    }

    public static ArrayList<TelephoneDirectory> readFile(String path) throws IOException, ClassNotFoundException {
        ArrayList<TelephoneDirectory> telephoneDirectories = new ArrayList<>();
        InputStream is = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(is);
        telephoneDirectories = (ArrayList<TelephoneDirectory>) ois.readObject();
        return telephoneDirectories;
    }

    public static void writeToFileCSV(String path) throws IOException {
        FileWriter fileWriter = new FileWriter(path, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (int i = 0; i < telephoneDirectoryManagement.size(); i++) {
            bufferedWriter.write(telephoneDirectoryManagement.getTelephoneDirectories().get(i).getPhoneNumber());
            bufferedWriter.write(telephoneDirectoryManagement.getTelephoneDirectories().get(i).getGroupOfDirectory());
            bufferedWriter.write(telephoneDirectoryManagement.getTelephoneDirectories().get(i).getName());
            bufferedWriter.write(telephoneDirectoryManagement.getTelephoneDirectories().get(i).getGender());
            bufferedWriter.write(telephoneDirectoryManagement.getTelephoneDirectories().get(i).getAddress());
            bufferedWriter.write(telephoneDirectoryManagement.getTelephoneDirectories().get(i).getDateOfBirth());
            bufferedWriter.write(telephoneDirectoryManagement.getTelephoneDirectories().get(i).getEmail());
        }
        bufferedWriter.close();
        fileWriter.close();
    }
}
