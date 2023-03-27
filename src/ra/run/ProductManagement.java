package ra.run;

import ra.bussinessImp.Catalog;
import ra.bussinessImp.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    public static List<Catalog> listCatalog = new ArrayList<>();
    public static List<Product> listProduct = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-2-MENU***************\n" +
                    "1. Nhập số danh mục sản phẩm và nhập thông tin các danh mục\n" +
                    "2. Nhập số sản phẩm và nhập thông tin các sản phẩm\n" +
                    "3. Sắp xếp sản phẩm theo giá sản phẩm tăng dần (Comparable/Comparator)\n" +
                    "4. Tìm kiếm sản phẩm theo tên danh mục sản phẩm\n" +
                    "5. Thoát");
            System.out.println("nhap lua chon");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    createCtalog();
                    break;
                case 2:
                    createProduct();
                    break;
                case 3:
                    sortProductWithPrice();
                    break;
                case 4:
                    searchByProductName();
                    break;
                case 5:
                    System.exit(0);
                default:
                    break;
            }
        }
    }

    private static void searchByProductName() {
        List<Product> listSearch = new ArrayList<>();
        System.out.println(" nhập tên danh mục muốn tìm kiếm ");
        String search = scanner.nextLine();
        for (Product product:listProduct) {
            if (product.getCatalog().getCatalogName().contains(search)){
                listSearch.add(product);
            }
        }
        if (listSearch.size()==0){
            System.out.println("không tìm thấy danh mục muốn tìm kiếm");
        }else {
            for (Product pro:listSearch) {
                pro.displayData();
            }
        }
    }

    private static void sortProductWithPrice() {
        Collections.sort(listProduct);
    }

    private static void createProduct() {
        System.out.println("nhập só sản phẩm muốn thêm \n");
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            Product product = new Product();
            product.inputData();
            if (listProduct.size()==0){
                product.setProductId(1);
            }else {
                product.setProductId(listProduct.get(listProduct.size()-1).getProductId()+1);
            }
            listProduct.add(product);

        }
    }

    private static void createCtalog() {
        System.out.println("nhập số danh mục muốn thêm \n");
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            Catalog catalog = new Catalog();
            catalog.inputData();
            if (listCatalog.size()==0){
                catalog.setCatalogId(1);
            }else {
                catalog.setCatalogId(listCatalog.get(listCatalog.size()-1).getCatalogId()+1);
            }
            listCatalog.add(catalog);
        }
    }
}