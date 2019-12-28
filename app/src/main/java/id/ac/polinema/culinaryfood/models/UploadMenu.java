package id.ac.polinema.culinaryfood.models;

public class UploadMenu {
    public String image;
    public String Menu,harga;

    public UploadMenu() {
    }

    public UploadMenu( String menu, String harga,String image) {
        if (menu.trim().equals("")|| harga.trim().equals("")){
            menu = "no menu";
            harga = "no harga";
        }

        Menu = menu;
        this.harga = harga;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
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
