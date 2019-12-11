package id.ac.polinema.culinaryfood.models;

public class MenuModel {
    public int image;
    public String Menu,harga;

    public MenuModel(int image, String menu, String harga) {
        this.image = image;
        Menu = menu;
        this.harga = harga;
    }
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getMenu() {
        return Menu;
    }

    public void setMenu(String menu) {
        Menu = menu;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
}
