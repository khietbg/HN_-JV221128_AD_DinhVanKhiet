package ra.bussinessImp;

import ra.bussiness.IShop;

import static ra.run.ProductManagement.listCatalog;
import static ra.run.ProductManagement.scanner;

public class Product implements IShop,Comparable<Product> {
    private int productId;
    private String productName;
    private String title;
    private String descriptions;
    private Catalog catalog;
    private float importPrice;
    private float exportPrice;
    private boolean productStatus;

    @Override
    public void inputData() {
        System.out.println("nhập tên sản phẩm");
        this.productName = scanner.nextLine();
        System.out.println("nhập tiêu đề");
        this.title = scanner.nextLine();
        System.out.println("nhập mô tả sản phẩm");
        this.descriptions = scanner.nextLine();
        for (Catalog catalog:listCatalog) {
            catalog.displayData();
        }
        System.out.println("chọn danh mục theo id");
        int id = Integer.parseInt(scanner.nextLine());
        for (Catalog catalog:listCatalog) {
            if (catalog.getCatalogId()==id){
                setCatalog(catalog);
            }
        }
        System.out.println("giá nhâp : ");
        this.importPrice = Float.parseFloat(scanner.nextLine());
        this.exportPrice= importPrice*RATE;
        System.out.println("trạng thái sản phẩm ");
        this.productStatus= Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("mã sản phẩm : %s \n",productId);
        System.out.printf("tên sản phẩm: %s \n",productName);
        System.out.printf("danh mục sản phẩm : %s \n",catalog.getCatalogName());
        System.out.printf("giá bán : %.1f \n",exportPrice);
        System.out.printf("trạng thái sản phẩm : %s \n",(productStatus?"đang bán":"không bán"));
        System.out.println("---------------------------------------------------------------------------");

    }

    public Product() {
    }

    public Product(int productId, String productName, String title, String descriptions, Catalog catalog, float importPrice, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.catalog = catalog;
        this.importPrice = importPrice;
        this.productStatus = productStatus;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public int compareTo(Product o) {
        return (int) (this.getExportPrice()-o.getExportPrice());
    }
}
