package id.ac.polinema.culinaryfood.models;

public class RestoModel {
    public int image;
    public String alamat, name;
    public String makanan;
    public String minuman;

    public RestoModel(int image, String alamat, String makanan, String minuman, String name) {
        this.image = image;
        this.name = name;
        this.alamat = alamat;
        this.makanan = makanan;
        this.minuman = minuman;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getMakanan() {
        return makanan;
    }

    public void setMakanan(String makanan) {
        this.makanan = makanan;
    }

    public String getMinuman() {
        return minuman;
    }

    public void setMinuman(String minuman) {
        this.minuman = minuman;
    }
}
