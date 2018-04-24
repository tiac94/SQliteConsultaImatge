package org.ieselcaminas.alu53787365w.deportesbbdd;

public class AndroidDeporte {
    //int logo;
    // Ara logo serà byte[] per a contenir directament la imatge, no int com abans
    byte[] logo;
    String titulo;
    String subtitulo;

    public AndroidDeporte(byte[] logo, String titulo, String subtitulo) {
        super();
        this.logo = logo;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubTitulo() {
        return subtitulo;
    }

    public void setSubTitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
}