/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableviewfilms;



/**
 *
 * @author Mohamed
 */
public class films {
    int id;
 String title,about,cover,gallery,trailer,date;
 
 
 String country,categorie;
 int duration;
    

//    films() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    films(int parseInt, String string, String string0, String string1, String string2) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    public void setId(int id) {
        this.id = id;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setGallery(String gallery) {
        this.gallery = gallery;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public int getDuration() {
        return duration;
    }

    public String getTitle() {
        return title;
    }

    public String getAbout() {
        return about;
    }

    public String getCover() {
        return cover;
    }

    public String getGallery() {
        return gallery;
    }

    public String getTrailer() {
        return trailer;
    }

    public String getCountry() {
        return country;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getDate() {
        return date;
    }

    public films(int id, int duration, String title, String about, String cover, String gallery, String trailer, String country, String categorie, String date) {
        this.id = id;
        this.duration = duration;
        this.title = title;
        this.about = about;
        this.cover = cover;
        this.gallery = gallery;
        this.trailer = trailer;
        this.country = country;
        this.categorie = categorie;
        this.date = date;
    }
   
    
}
