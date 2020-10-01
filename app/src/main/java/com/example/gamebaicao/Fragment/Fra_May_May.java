package com.example.gamebaicao.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.gamebaicao.R;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Fra_May_May extends Fragment {

    ImageView imgMay1_1, imgMay1_2, imgMay1_3, imgMay2_1, imgMay2_2, imgMay2_3;
    TextView txtKetQua, txtDiemMay1, txtDiemMay2, txtSoVanCon;
    ImageView imgButtonPlay;
    ArrayList<LaBai> lstDSBai = new ArrayList<LaBai>();
    private int tongDiemMay1 = 0, tongDiemMay2 = 0;
    private int soVan = 0;
    private int soVanCon = 20;

    private int mangDiemThuTu[] = {
            1,5,9,13,17,21,25,29,33,37,41,45,49,2,6,10,14,18,22,26,30,34,38,42,46,50,3,7,11,15,19,23,27,
            31,35,39,43,47,51,4,8,12,16,20,24,28,32,36,40,44,48,52
    };

    private int mangHinhBaiCo[] = {
            R.drawable.h1,R.drawable.h2,R.drawable.h3,R.drawable.h4,R.drawable.h5,
            R.drawable.h6,R.drawable.h7,R.drawable.h8,R.drawable.h9,R.drawable.h10,
            R.drawable.hj,R.drawable.hq,R.drawable.hk
    };
    private int mangHinhBaiRo[] = {
            R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,
            R.drawable.d6,R.drawable.d7,R.drawable.d8,R.drawable.d9,R.drawable.d10,
            R.drawable.dj,R.drawable.dq,R.drawable.dk
    };
    private int mangHinhBaiChuon[] = {
            R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,
            R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,
            R.drawable.cj,R.drawable.cq,R.drawable.ck
    };
    private int mangHinhBaiBich[] = {
            R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5,
            R.drawable.s6,R.drawable.s7,R.drawable.s8,R.drawable.s9,R.drawable.s10,
            R.drawable.sj,R.drawable.sq,R.drawable.sk
    };
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_fra__may__may, container, false);

        ConnectView();
        setDuLieuBai();
        imgButtonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CountDownTimer(20000, 1000)
                {
                    public void onTick(long millisUntilFinished){
                        if(tongDiemMay1 > 10 || tongDiemMay2 > 10)
                        {
                            onFinish();
                        }
                        else
                            chiaBai();
                    }
                    public  void onFinish(){
                        Snackbar.make(getView(), "Đã xong", Snackbar.LENGTH_LONG).show();
                    }
                }.start();
            }
        });

        return view;
    }
    void ConnectView()
    {
        imgMay2_1 = (ImageView)view.findViewById(R.id.imageViewBaiMay2_1);
        imgMay2_2 = (ImageView)view.findViewById(R.id.imageViewBaiMay2_2);
        imgMay2_3 = (ImageView)view.findViewById(R.id.imageViewBaiMay2_3);
        imgMay1_1 = (ImageView)view.findViewById(R.id.imageViewBaiMay1_1);
        imgMay1_2 = (ImageView)view.findViewById(R.id.imageViewBaiMay1_2);
        imgMay1_3 = (ImageView)view.findViewById(R.id.imageViewBaiMay1_3);
        txtKetQua = (TextView)view.findViewById(R.id.txtDiemTong);
        txtDiemMay2 = (TextView)view.findViewById(R.id.txtDiemMay2);
        txtDiemMay1 = (TextView)view.findViewById(R.id.txtDiemMay1);
        txtSoVanCon = (TextView)view.findViewById(R.id.txtSoVanConLai);
        imgButtonPlay = (ImageView)view.findViewById(R.id.imgButtonPlay);
    }

    public void setDuLieuBai()
    {
        for(int i = 1; i <= 52; i++)
        {
            LaBai labai = new LaBai(i);
            if(i <= 13)
            {
                if(i < 10)
                    labai.setDiem(i);
                else
                    labai.setDiem(10);
                labai.setHinh(mangHinhBaiBich[i-1]);
            }
            else if(i > 13 && i <= 26)
            {
                if(i < 23)
                    labai.setDiem(i - 13);
                else
                    labai.setDiem(10);
                labai.setHinh(mangHinhBaiChuon[i-14]);
            }
            else if(i > 26 && i <= 39)
            {
                if(i < 36)
                    labai.setDiem(i - 26);
                else
                    labai.setDiem(10);
                labai.setHinh(mangHinhBaiRo[i - 27]);
            }
            else
            {
                if(i < 49)
                    labai.setDiem(i - 39);
                else
                    labai.setDiem(10);
                labai.setHinh(mangHinhBaiCo[i - 40]);
            }
            labai.setDiemBai(mangDiemThuTu[i-1]);
            lstDSBai.add(labai);
        }
    }

    public void chiaBai()
    {
        Random random = new Random();
        int may1_1 = random.nextInt(52) + 1;
        int may1_2 = random.nextInt(52) + 1;
        while(true)
        {
            if(may1_1 != may1_2)
                break;
            else
                may1_2 = random.nextInt(52) + 1;
        }

        int may1_3 = random.nextInt(52) + 1;
        while (true)
        {
            if(may1_1 != may1_3 && may1_2 != may1_3)
                break;
            else
                may1_3 = random.nextInt(52) + 1;
        }
        int[] lstBaiNguoi = {may1_1, may1_2, may1_3};
        int may2_1 = random.nextInt(52) + 1;
        for(int i = 0; i < lstBaiNguoi.length; i++)
        {
            while (true)
            {
                if(may2_1 != lstBaiNguoi[i])
                    break;
                else
                    may2_1 = random.nextInt(52) + 1;
            }
        }
        int may2_2 = random.nextInt(52) + 1;
        for(int i = 0; i < lstBaiNguoi.length; i++)
        {
            while (true)
            {
                if(may2_2 != lstBaiNguoi[i] && may2_2 != may2_1)
                    break;
                else
                    may2_2 = random.nextInt(52) + 1;
            }
        }

        int may2_3 = random.nextInt(52) + 1;
        for(int i = 0; i < lstBaiNguoi.length; i++)
        {
            while (true)
            {
                if(may2_3 != lstBaiNguoi[i] && may2_3 != may2_1 && may2_3 != may2_2)
                    break;
                else
                    may2_3 = random.nextInt(52) + 1;
            }
        }
        final LaBai baiMay1_1 = getLaBaiById(may1_1);
        final LaBai baiMay1_2 = getLaBaiById(may1_2);
        final LaBai baiMay1_3 = getLaBaiById(may1_3);
        final LaBai baiMay2_1 = getLaBaiById(may2_1);
        final LaBai baiMay2_2 = getLaBaiById(may2_2);
        final LaBai baiMay2_3 = getLaBaiById(may2_3);
        this.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                imgMay1_1.setImageResource(baiMay1_1.getHinh());
                imgMay1_2.setImageResource(baiMay1_2.getHinh());
                imgMay1_3.setImageResource(baiMay1_3.getHinh());
                imgMay2_1.setImageResource(baiMay2_1.getHinh());
                imgMay2_2.setImageResource(baiMay2_2.getHinh());
                imgMay2_3.setImageResource(baiMay2_3.getHinh());
                soVan++;
                soVanCon--;
                txtSoVanCon.setText("Còn " + soVanCon + " ván");
                int Ktra3LaTrungCua_May1 = KiemTraBaLaTrungNhau(baiMay1_1, baiMay1_2, baiMay1_3);
                int Ktra3LaTrungCua_May2 = KiemTraBaLaTrungNhau(baiMay2_1, baiMay2_2, baiMay2_3);
                if(Ktra3LaTrungCua_May1 != -1)
                {
                    txtDiemMay1.setText("Máy 1: Ba lá trùng");
                    if(Ktra3LaTrungCua_May2 != -1)
                    {
                        txtDiemMay2.setText("Máy 2: Ba lá trùng");
                        if(Ktra3LaTrungCua_May1 > Ktra3LaTrungCua_May2)
                        {
                            tongDiemMay1 += 1;
                        }
                        else
                        {
                            tongDiemMay2 += 1;
                        }
                    }
                    else
                    {
                        int KtraBaLaHinhCua_May2 = KiemTraBaHinh(baiMay2_1, baiMay2_2, baiMay2_3);
                        if(KtraBaLaHinhCua_May2 != -1)
                        {
                            txtDiemMay2.setText("Máy 2: Ba lá hình");
                            tongDiemMay1 += 1;
                        }
                        else
                        {
                            int diem_May2 = TinhDiem(baiMay2_1, baiMay2_2, baiMay2_3);
                            txtDiemMay2.setText("Máy 2: " + diem_May2 + "điểm");
                            tongDiemMay1 += 1;
                        }
                    }
                }

                else if(Ktra3LaTrungCua_May2 != -1)
                {
                    txtDiemMay2.setText("Máy 2: Ba lá trùng");
                    if(Ktra3LaTrungCua_May1 != -1)
                    {
                        txtDiemMay1.setText("Máy 1: Ba lá trùng");
                        if(Ktra3LaTrungCua_May1 > Ktra3LaTrungCua_May2)
                        {
                            tongDiemMay1 += 1;
                        }
                        else
                        {
                            tongDiemMay2 += 1;
                        }
                    }
                    else
                    {
                        int KtraBaLaHinhCua_May1 = KiemTraBaHinh(baiMay1_1, baiMay1_2, baiMay1_3);
                        if(KtraBaLaHinhCua_May1 != -1)
                        {
                            txtDiemMay1.setText("Máy 1: Ba lá hình");
                            tongDiemMay2 += 1;
                        }
                        else
                        {
                            int diem_May1 = TinhDiem(baiMay1_1, baiMay1_2, baiMay1_3);
                            txtDiemMay1.setText("Máy 1: " + diem_May1 + "điểm");
                            tongDiemMay2 += 1;
                        }
                    }
                }
                else
                {
                    int Ktra3LaHinhCua_May1 = KiemTraBaHinh(baiMay1_1, baiMay1_2, baiMay1_3);
                    int Ktra3LaHinhCua_May2 = KiemTraBaHinh(baiMay2_1, baiMay2_2, baiMay2_3);
                    if(Ktra3LaHinhCua_May1 != -1)
                    {
                        txtDiemMay1.setText("Máy 1: Ba lá hình");
                        if(Ktra3LaHinhCua_May2 != -1)
                        {
                            txtDiemMay2.setText("Máy 2: Ba lá hình");
                            if(Ktra3LaHinhCua_May1 > Ktra3LaHinhCua_May2)
                            {
                                tongDiemMay1 += 1;
                            }
                            else
                            {
                                tongDiemMay2 += 1;
                            }
                        }
                        else
                        {
                            int diem_May2 = TinhDiem(baiMay2_1, baiMay2_2, baiMay2_3);
                            txtDiemMay2.setText("Máy 2: " + diem_May2 + "điểm");
                            tongDiemMay1 += 1;
                        }
                    }
                    else if(Ktra3LaHinhCua_May2 != -1)
                    {
                        txtDiemMay2.setText("Máy 2: Ba lá hình");
                        if(Ktra3LaHinhCua_May1 != -1)
                        {
                            txtDiemMay1.setText("Máy 1: Ba lá hình");
                            if(Ktra3LaHinhCua_May1 > Ktra3LaHinhCua_May2)
                            {
                                tongDiemMay1 += 1;
                            }
                            else
                            {
                                tongDiemMay2 += 1;
                            }
                        }
                        else
                        {
                            int diem_May1 = TinhDiem(baiMay1_1, baiMay1_2, baiMay1_3);
                            txtDiemMay1.setText("Máy 1: " + diem_May1 + "điểm");
                            tongDiemMay2 += 1;
                        }
                    }
                    else
                    {
                        int diem_May1 = TinhDiem(baiMay1_1, baiMay1_2, baiMay1_3);
                        int diem_May2 = TinhDiem(baiMay2_1, baiMay2_2, baiMay2_3);
                        txtDiemMay1.setText("Máy 1: " + diem_May1 + "điểm");
                        txtDiemMay2.setText("Máy 2: " + diem_May2 + "điểm");
                        if(diem_May1 > diem_May2)
                            tongDiemMay1 += 1;
                        else if(diem_May2 > diem_May1)
                            tongDiemMay2 += 1;
                        else
                        {
                            int LaBaiCaoNhatCua_May1 = LayLaBaiCaoNhat(baiMay1_1, baiMay1_2, baiMay1_3);
                            int LaBaiCaoNhatCua_May2 = LayLaBaiCaoNhat(baiMay2_1, baiMay2_2, baiMay2_3);
                            System.out.println("lá bài cao nhất của Máy" + LaBaiCaoNhatCua_May2);
                            System.out.println("lá bài cao nhất của Người" + LaBaiCaoNhatCua_May1);
                            if(LaBaiCaoNhatCua_May2 > LaBaiCaoNhatCua_May1)
                                tongDiemMay2 += 1;
                            else
                                tongDiemMay1 += 1;
                        }
                    }
                }
                txtKetQua.setText("Kết Quả: \t\t\t\tMáy 1: " + tongDiemMay1 + "\t\t|\t\t Máy 2: " + tongDiemMay2);
                if(tongDiemMay1 > 10 || tongDiemMay2 > 10)
                {
                    final AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
                    alertDialog.setTitle("Kết Quả");
                    if(tongDiemMay1 > tongDiemMay2)
                        alertDialog.setMessage("Tổng điểm Máy 1: " + tongDiemMay1 + "\nTổng điểm Máy 2: " + tongDiemMay2 + "\nKết luận: Máy 1 thắng");
                    else if(tongDiemMay2 > tongDiemMay1)
                        alertDialog.setMessage("Tổng điểm Máy 1: " + tongDiemMay1 + "\nTổng điểm Máy 2: " + tongDiemMay2 + "\nKết luận: Máy 2 thắng");
                    alertDialog.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            tongDiemMay2 = 0;
                            tongDiemMay1 = 0;
                            soVan = 0;
                            soVanCon = 20;
                            txtDiemMay2.setText("Máy 2: ");
                            txtDiemMay1.setText("Máy 1: ");
                            txtKetQua.setText("Kết Quả: \t\t\t\tMáy 1: 0 \t\t|\t\t Máy 2: 0");
                            txtSoVanCon.setText("Còn 20 ván");
                            imgMay2_1.setImageResource(R.drawable.anhbaiup);
                            imgMay2_2.setImageResource(R.drawable.anhbaiup);
                            imgMay2_3.setImageResource(R.drawable.anhbaiup);
                            imgMay1_1.setImageResource(R.drawable.anhbaiup);
                            imgMay1_2.setImageResource(R.drawable.anhbaiup);
                            imgMay1_3.setImageResource(R.drawable.anhbaiup);
                            AlertDialog dialog = alertDialog.create();
                            dialog.dismiss();
                        }
                    });
                    AlertDialog dialog = alertDialog.create();
                    dialog.show();
                }
                else if(soVan == 20)
                {
                    final AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
                    alertDialog.setTitle("Kết Quả");
                    if(tongDiemMay1 > tongDiemMay2)
                        alertDialog.setMessage("Tổng điểm Máy 1: " + tongDiemMay1 + "\nTổng điểm Máy 2: " + tongDiemMay2 + "\nKết luận: Máy 1 thắng");
                    else if(tongDiemMay2 > tongDiemMay1)
                        alertDialog.setMessage("Tổng điểm Máy 1: " + tongDiemMay1 + "\nTổng điểm Máy 2: " + tongDiemMay2 + "\nKết luận: Máy 2 thắng");
                    else
                        alertDialog.setMessage("Tổng điểm Máy 1: " + tongDiemMay1 + "\nTổng điểm Máy 2: " + tongDiemMay2 + "\nKết luận: Hòa");
                    alertDialog.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            tongDiemMay2 = 0;
                            tongDiemMay1 = 0;
                            soVan = 0;
                            soVanCon = 20;
                            txtDiemMay2.setText("Máy 2: ");
                            txtDiemMay1.setText("Máy 1: ");
                            txtKetQua.setText("Kết Quả: \t\t\t\tMáy 1: 0 \t\t|\t\t Máy 2: 0");
                            txtSoVanCon.setText("Còn 20 ván");
                            imgMay2_1.setImageResource(R.drawable.anhbaiup);
                            imgMay2_2.setImageResource(R.drawable.anhbaiup);
                            imgMay2_3.setImageResource(R.drawable.anhbaiup);
                            imgMay1_1.setImageResource(R.drawable.anhbaiup);
                            imgMay1_2.setImageResource(R.drawable.anhbaiup);
                            imgMay1_3.setImageResource(R.drawable.anhbaiup);
                            AlertDialog dialog = alertDialog.create();
                            dialog.dismiss();
                        }
                    });
                    AlertDialog dialog = alertDialog.create();
                    dialog.show();
                }
            }
        });



    }
    public LaBai getLaBaiById(int id)
    {
        for(LaBai laBai : lstDSBai)
        {
            if(laBai.getId() == id)
                return laBai;
        }
        return null;
    }

    public int TinhDiem(LaBai bai1, LaBai bai2, LaBai bai3)
    {
        int tongDiem = bai1.getDiem() + bai2.getDiem() + bai3.getDiem();
        tongDiem = tongDiem % 10;
        return tongDiem;
    }
    public int LayLaBaiCaoNhat(LaBai bai1, LaBai bai2, LaBai bai3)
    {
        int diemBai1 = bai1.getDiemBai();
        int diemBai2 = bai2.getDiemBai();
        int diemBai3 = bai3.getDiemBai();
        int max1_2 = Math.max(diemBai1, diemBai2);
        int max = Math.max(max1_2, diemBai3);
        return max;
    }

    public int KiemTraBaHinh(LaBai bai1, LaBai bai2, LaBai bai3)
    {
        if((bai1.getId() > 10 && bai1.getId() <= 13) || (bai1.getId() > 23 && bai1.getId() <= 26) || (bai1.getId() > 36 && bai1.getId() <= 39) || (bai1.getId() > 49 && bai1.getId() <= 52))
        {
            if((bai2.getId() > 10 && bai2.getId() <= 13) || (bai2.getId() > 23 && bai2.getId() <= 26) || (bai2.getId() > 36 && bai2.getId() <= 39) || (bai2.getId() > 49 && bai2.getId() <= 52))
            {
                if((bai3.getId() > 10 && bai3.getId() <= 13) || (bai3.getId() > 23 && bai3.getId() <= 26) || (bai3.getId() > 36 && bai3.getId() <= 39) || (bai3.getId() > 49 && bai3.getId() <= 52))
                {
                    int diemBai1 = bai1.getDiemBai();
                    int diemBai2 = bai2.getDiemBai();
                    int diemBai3 = bai3.getDiemBai();
                    int max1_2 = Math.max(diemBai1, diemBai2);
                    int max = Math.max(max1_2, diemBai3);
                    return max;
                }
            }
        }
        return -1;
    }

    public int KiemTraBaLaTrungNhau(LaBai bai1, LaBai bai2, LaBai bai3)
    {
        int id1 = bai1.getId(), id2 = bai2.getId(), id3 = bai3.getId();
        int ktra1 = id1 - id2;
        if(Math.abs(ktra1) == 13 || Math.abs(ktra1) == 26 || Math.abs(ktra1) == 39)
        {
            int ktra2 = id1 - id3;
            if(Math.abs(ktra2) == 13 || Math.abs(ktra2) == 26 || Math.abs(ktra2) == 39)
            {
                int diemBai1 = bai1.getDiemBai();
                int diemBai2 = bai2.getDiemBai();
                int diemBai3 = bai3.getDiemBai();
                int max1_2 = Math.max(diemBai1, diemBai2);
                int max = Math.max(max1_2, diemBai3);
                return max;
            }
        }
        return -1;
    }
}
