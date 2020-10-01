package com.example.gamebaicao.Fragment;

public class LaBai {

    private int id, hinh, diem, diemBai;

    public int getDiemBai() {
        return diemBai;
    }

    public void setDiemBai(int diemBai) {
        this.diemBai = diemBai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public LaBai(int id) {
        this.id = id;
    }

    public LaBai(int id, int hinh, int diem) {
        this.id = id;
        this.hinh = hinh;
        this.diem = diem;
    }
}
