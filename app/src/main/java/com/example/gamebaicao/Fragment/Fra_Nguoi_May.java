package com.example.gamebaicao.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gamebaicao.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Random;

public class Fra_Nguoi_May extends Fragment {
    ImageView imgNguoi1, imgNguoi2, imgNguoi3, imgMay1, imgMay2, imgMay3;
    TextView txtKetQua, txtDiemNguoiChoi, txtDiemMay, txtSoVanConLai;
    Button btnPlay, btnLatBai, btnKetThuc;
    ArrayList<LaBai> lstDSBai = new ArrayList<LaBai>();
    private int tongDiemNguoi = 0, tongDiemMay = 0;
    private int soVan = 0;
    private int soVanCon = 20;
    int soBaiDaLat = 0;
    private LaBai baiNguoi1 = new LaBai();
    private LaBai baiNguoi2 = new LaBai();
    private LaBai baiNguoi3 = new LaBai();
    private LaBai baiMay1 = new LaBai();
    private LaBai baiMay2 = new LaBai();
    private LaBai baiMay3 = new LaBai();
    int img1Click = 0, img2Click = 0, img3Click = 0, btnLatBaiClick = 0, btnChiaBaiClick = 0;
    private int mangDiemThuTu[] = {
            49,1,5,9,13,17,21,25,29,33,37,41,45,50,2,6,10,14,18,22,26,30,34,38,42,46,51,3,7,11,15,19,23,
            27,31,35,39,43,47,52,4,8,12,16,20,24,28,32,36,40,44,48
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
        view = inflater.inflate(R.layout.activity_fra_nguoi__may, container, false);
        ConnecView();
        setDuLieuBai();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnChiaBaiClick == 0)
                {
                    btnChiaBaiClick = 1;
                    chiaBai();
                }
                else if(soBaiDaLat >= 0 && soBaiDaLat < 3)
                {
                    AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                    alert.setTitle("Thông báo");
                    alert.setMessage("Vui lòng lật bài của người chơi");
                    alert.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog myAlert = alert.create();
                    myAlert.show();
                }
                else if(soBaiDaLat == 3)
                {
                    img1Click = 0;
                    img2Click = 0;
                    img3Click = 0;
                    imgNguoi1.setImageResource(R.drawable.anhbaiup);
                    imgNguoi2.setImageResource(R.drawable.anhbaiup);
                    imgNguoi3.setImageResource(R.drawable.anhbaiup);
                    soBaiDaLat = 0;
                    btnLatBaiClick = 0;
                    txtDiemNguoiChoi.setText("Bạn: ");
                    chiaBai();
                }

            }
        });

        imgNguoi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnChiaBaiClick == 0)
                {
                    AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                    alert.setTitle("Thông báo");
                    alert.setMessage("Vui lòng chia bài");
                    alert.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog myAlert = alert.create();
                    myAlert.show();
                }
                else if(soBaiDaLat >= 0 && soBaiDaLat < 3 && img1Click == 0)
                {
                    soBaiDaLat++;
                    img1Click = 1;
                    imgNguoi1.setImageResource(baiNguoi1.getHinh());
                }
                else if(img1Click == 1 || soBaiDaLat == 3)
                {
                    AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                    alert.setTitle("Thông báo");
                    alert.setMessage("Bài này đã lật rồi");
                    alert.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog myAlert = alert.create();
                    myAlert.show();
                }
                if(soBaiDaLat == 3 && img1Click == 1)
                {
                    img1Click = 0;
                    img2Click = 0;
                    img3Click = 0;
                    btnLatBaiClick = 1;
                    KetQua();
                }
            }
        });
        imgNguoi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnChiaBaiClick == 0)
                {
                    AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                    alert.setTitle("Thông báo");
                    alert.setMessage("Vui lòng chia bài");
                    alert.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog myAlert = alert.create();
                    myAlert.show();
                }
                else if(soBaiDaLat >= 0 && soBaiDaLat < 3 && img2Click == 0)
                {
                    soBaiDaLat++;
                    img2Click = 1;
                    imgNguoi2.setImageResource(baiNguoi2.getHinh());
                }
                else if(img2Click == 1 || soBaiDaLat == 3)
                {
                    AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                    alert.setTitle("Thông báo");
                    alert.setMessage("Bài này đã lật rồi");
                    alert.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog myAlert = alert.create();
                    myAlert.show();
                }
                if(soBaiDaLat == 3 && img2Click == 1)
                {
                    img1Click = 0;
                    img2Click = 0;
                    img3Click = 0;
                    btnLatBaiClick = 1;
                    KetQua();
                }
            }
        });
        imgNguoi3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnChiaBaiClick == 0)
                {
                    AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                    alert.setTitle("Thông báo");
                    alert.setMessage("Vui lòng chia bài");
                    alert.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog myAlert = alert.create();
                    myAlert.show();
                }
                else if(soBaiDaLat >= 0 && soBaiDaLat < 3 && img3Click == 0)
                {
                    soBaiDaLat++;
                    img3Click = 1;
                    imgNguoi3.setImageResource(baiNguoi3.getHinh());
                }
                else if(img3Click == 1 || soBaiDaLat == 3)
                {
                    AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                    alert.setTitle("Thông báo");
                    alert.setMessage("Bài này đã lật rồi");
                    alert.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog myAlert = alert.create();
                    myAlert.show();
                }
                if(soBaiDaLat == 3 && img3Click == 1)
                {
                    img1Click = 0;
                    img2Click = 0;
                    img3Click = 0;
                    btnLatBaiClick = 1;
                    KetQua();
                }
            }
        });

        btnLatBai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnChiaBaiClick == 0)
                {
                    AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                    alert.setTitle("Thông báo");
                    alert.setMessage("Vui lòng chia bài");
                    alert.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog myAlert = alert.create();
                    myAlert.show();
                }
                else
                {
                    if(btnLatBaiClick == 0)
                    {
                        btnLatBaiClick = 1;
                        img1Click = 0;
                        img2Click = 0;
                        img3Click = 0;
                        soBaiDaLat = 3;
                        imgNguoi1.setImageResource(baiNguoi1.getHinh());
                        imgNguoi2.setImageResource(baiNguoi2.getHinh());
                        imgNguoi3.setImageResource(baiNguoi3.getHinh());
                        KetQua();
                    }
                    else
                    {
                        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                        alert.setTitle("Thông báo");
                        alert.setMessage("Đã lật bài người chơi rồi");
                        alert.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                        AlertDialog myAlert = alert.create();
                        myAlert.show();
                    }
                }
            }
        });

        btnKetThuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnChiaBaiClick == 1 && soBaiDaLat == 3)
                    KetThucGame();
                else if(btnChiaBaiClick == 0)
                {
                    AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                    alert.setTitle("Thông báo");
                    alert.setMessage("Bạn chưa bắt đầu game");
                    alert.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog myAlert = alert.create();
                    myAlert.show();
                }
                else
                {
                    AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                    alert.setTitle("Thông báo");
                    alert.setMessage("Bạn phải chơi hết ván game");
                    alert.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog myAlert = alert.create();
                    myAlert.show();
                }
            }
        });
        return view;
    }

    void ConnecView()
    {
        imgMay1 = (ImageView)view.findViewById(R.id.imageViewBaiMay1);
        imgMay2 = (ImageView)view.findViewById(R.id.imageViewBaiMay2);
        imgMay3 = (ImageView)view.findViewById(R.id.imageViewBaiMay3);
        imgNguoi1 = (ImageView)view.findViewById(R.id.imageViewBaiNguoiChoi1);
        imgNguoi2 = (ImageView)view.findViewById(R.id.imageViewBaiNguoiChoi2);
        imgNguoi3 = (ImageView)view.findViewById(R.id.imageViewBaiNguoiChoi3);
        txtKetQua = (TextView)view.findViewById(R.id.txtDiemTong);
        txtDiemMay = (TextView)view.findViewById(R.id.txtDiemMay);
        txtDiemNguoiChoi = (TextView)view.findViewById(R.id.txtDiemNguoiChoi);
        txtSoVanConLai = (TextView)view.findViewById(R.id.txtSoVanConLai);
        btnPlay = (Button) view.findViewById(R.id.btnPlay);
        btnLatBai = (Button) view.findViewById(R.id.btnLatBai);
        btnKetThuc = (Button) view.findViewById(R.id.btnKetThuc);

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

    private int diem_May;

    public void chiaBai()
    {
        Random random = new Random();
        int nguoi1 = random.nextInt(52) + 1;
        int nguoi2 = random.nextInt(52) + 1;
        while(true)
        {
            if(nguoi1 != nguoi2)
                break;
            else
                nguoi2 = random.nextInt(52) + 1;
        }

        int nguoi3 = random.nextInt(52) + 1;
        while (true)
        {
            if(nguoi1 != nguoi3 && nguoi2 != nguoi3)
                break;
            else
                nguoi3 = random.nextInt(52) + 1;
        }
        int[] lstBaiNguoi = {nguoi1, nguoi2, nguoi3};
        int may1 = random.nextInt(52) + 1;
        for(int i = 0; i < lstBaiNguoi.length; i++)
        {
            while (true)
            {
                if(may1 != lstBaiNguoi[i])
                    break;
                else
                    may1 = random.nextInt(52) + 1;
            }
        }
        int may2 = random.nextInt(52) + 1;
        for(int i = 0; i < lstBaiNguoi.length; i++)
        {
            while (true)
            {
                if(may2 != lstBaiNguoi[i] && may2 != may1)
                    break;
                else
                    may2 = random.nextInt(52) + 1;
            }
        }

        int may3 = random.nextInt(52) + 1;
        for(int i = 0; i < lstBaiNguoi.length; i++)
        {
            while (true)
            {
                if(may3 != lstBaiNguoi[i] && may3 != may1 && may3 != may2)
                    break;
                else
                    may3 = random.nextInt(52) + 1;
            }
        }
        soVan++;
        soVanCon--;
        txtSoVanConLai.setText("Còn " + soVanCon + " ván");
        //lấy ra lá bài của người
        baiNguoi1 = getLaBaiById(nguoi1);
        baiNguoi2 = getLaBaiById(nguoi2);
        baiNguoi3 = getLaBaiById(nguoi3);
        //lấy ra lá bài của máy
        baiMay1 = getLaBaiById(may1);
        baiMay2 = getLaBaiById(may2);
        baiMay3 = getLaBaiById(may3);
        //set hình cho bài máy
        imgMay1.setImageResource(baiMay1.getHinh());
        imgMay2.setImageResource(baiMay2.getHinh());
        imgMay3.setImageResource(baiMay3.getHinh());

        if(KiemTraBaLaTrungNhau(baiMay1, baiMay2, baiMay3) != -1)
            txtDiemMay.setText("Máy: Ba Lá trùng nhau");
        else if(KiemTraBaHinh(baiMay1, baiMay2, baiMay3) != -1)
            txtDiemMay.setText("Máy: Ba Lá hình");
        else
        {
            diem_May = TinhDiem(baiMay1, baiMay2, baiMay3);
            txtDiemMay.setText("Máy: " + diem_May + " Điểm");
        }

    }

    void KetQua()
    {
        this.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                int Ktra3LaTrungCua_Nguoi = KiemTraBaLaTrungNhau(baiNguoi1, baiNguoi2, baiNguoi3);
                int Ktra3LaTrungCua_May = KiemTraBaLaTrungNhau(baiMay1, baiMay2, baiMay3);
                if(Ktra3LaTrungCua_Nguoi != -1)
                {
                    txtDiemNguoiChoi.setText("Bạn: Ba lá trùng");
                    if(Ktra3LaTrungCua_May != -1)
                    {
                        if(Ktra3LaTrungCua_Nguoi > Ktra3LaTrungCua_May)
                        {
                            tongDiemNguoi += 1;
                            Snackbar.make(getView(), "Bạn thắng", Snackbar.LENGTH_LONG).show();
                        }
                        else
                        {
                            tongDiemMay += 1;
                            Snackbar.make(getView(), "Máy thắng", Snackbar.LENGTH_LONG).show();
                        }
                    }
                    else
                    {
                        int KtraBaLaHinhCua_May = KiemTraBaHinh(baiMay1, baiMay2, baiMay3);
                        if(KtraBaLaHinhCua_May != -1)
                        {
                            tongDiemNguoi += 1;
                            Snackbar.make(getView(), "Bạn thắng", Snackbar.LENGTH_LONG).show();
                        }
                        else
                        {
                            tongDiemNguoi += 1;
                            Snackbar.make(getView(), "Bạn thắng", Snackbar.LENGTH_LONG).show();
                        }
                    }
                }

                else if(Ktra3LaTrungCua_May != -1)
                {
                    if(Ktra3LaTrungCua_Nguoi != -1)
                    {
                        txtDiemNguoiChoi.setText("Bạn: Ba lá trùng");
                        if(Ktra3LaTrungCua_Nguoi > Ktra3LaTrungCua_May)
                        {
                            tongDiemNguoi += 1;
                            Snackbar.make(getView(), "Bạn thắng", Snackbar.LENGTH_LONG).show();
                        }
                        else
                        {
                            tongDiemMay += 1;
                            Snackbar.make(getView(), "Máy thắng", Snackbar.LENGTH_LONG).show();
                        }
                    }
                    else
                    {
                        int KtraBaLaHinhCua_Nguoi = KiemTraBaHinh(baiNguoi1, baiNguoi2, baiNguoi3);
                        if(KtraBaLaHinhCua_Nguoi != -1)
                        {
                            txtDiemNguoiChoi.setText("Bạn: Ba lá hình");
                            tongDiemMay += 1;
                            Snackbar.make(getView(), "Máy thắng", Snackbar.LENGTH_LONG).show();
                        }
                        else
                        {
                            int diem_Nguoi = TinhDiem(baiNguoi1, baiNguoi2, baiNguoi3);
                            txtDiemNguoiChoi.setText("Bạn: " + diem_Nguoi + "điểm");
                            tongDiemMay += 1;
                            Snackbar.make(getView(), "Máy thắng", Snackbar.LENGTH_LONG).show();
                        }
                    }
                }
                else
                {

                    int Ktra3LaHinhCua_Nguoi = KiemTraBaHinh(baiNguoi1, baiNguoi2, baiNguoi3);
                    int Ktra3LaHinhCua_May = KiemTraBaHinh(baiMay1, baiMay2, baiMay3);

                    //Kiểm tra bài đôi
                    int KtraBaiDoiCua_Nguoi = KiemTraBaiDoi(baiNguoi1, baiNguoi2, baiNguoi3);
                    int KtraBaiDoiCua_May = KiemTraBaiDoi(baiMay1, baiMay2, baiMay3);


                    if(Ktra3LaHinhCua_Nguoi != -1)
                    {
                        txtDiemNguoiChoi.setText("Bạn: Ba lá hình");
                        if(Ktra3LaHinhCua_May != -1)
                        {
                            if(KtraBaiDoiCua_Nguoi != -1)
                            {
                                if(KtraBaiDoiCua_May != -1)
                                {
                                    if(KtraBaiDoiCua_Nguoi > KtraBaiDoiCua_May)
                                    {
                                        tongDiemNguoi += 1;
                                        Snackbar.make(getView(), "Bạn thắng", Snackbar.LENGTH_LONG).show();
                                    }
                                    else
                                    {
                                        tongDiemMay += 1;
                                        Snackbar.make(getView(), "Máy thắng", Snackbar.LENGTH_LONG).show();
                                    }
                                }
                                else
                                {
                                    tongDiemNguoi += 1;
                                    Snackbar.make(getView(), "Bạn thắng", Snackbar.LENGTH_LONG).show();
                                }
                            }
                            else if(KtraBaiDoiCua_May != -1)
                            {
                                if(KtraBaiDoiCua_Nguoi != -1)
                                {
                                    if(KtraBaiDoiCua_Nguoi > KtraBaiDoiCua_May)
                                    {
                                        tongDiemNguoi += 1;
                                        Snackbar.make(getView(), "Bạn thắng", Snackbar.LENGTH_LONG).show();
                                    }
                                    else
                                    {
                                        tongDiemMay += 1;
                                        Snackbar.make(getView(), "Máy thắng", Snackbar.LENGTH_LONG).show();
                                    }
                                }
                                else
                                {
                                    tongDiemMay += 1;
                                    Snackbar.make(getView(), "Máy thắng", Snackbar.LENGTH_LONG).show();
                                }
                            }
                            else
                            {
                                if(Ktra3LaHinhCua_Nguoi > Ktra3LaHinhCua_May)
                                {
                                    tongDiemNguoi += 1;
                                    Snackbar.make(getView(), "Bạn thắng", Snackbar.LENGTH_LONG).show();
                                }
                                else
                                {
                                    tongDiemMay += 1;
                                    Snackbar.make(getView(), "Máy thắng", Snackbar.LENGTH_LONG).show();
                                }
                            }
                        }
                        else
                        {
                            tongDiemNguoi += 1;
                            Snackbar.make(getView(), "Bạn thắng", Snackbar.LENGTH_LONG).show();
                        }
                    }
                    else if(Ktra3LaHinhCua_May != -1)
                    {
                        if(Ktra3LaHinhCua_Nguoi != -1)
                        {
                            txtDiemNguoiChoi.setText("Bạn: Ba lá hình");
                            if(KtraBaiDoiCua_Nguoi != -1)
                            {
                                if(KtraBaiDoiCua_May != -1)
                                {
                                    if(KtraBaiDoiCua_Nguoi > KtraBaiDoiCua_May)
                                    {
                                        tongDiemNguoi += 1;
                                        Snackbar.make(getView(), "Bạn thắng", Snackbar.LENGTH_LONG).show();
                                    }
                                    else
                                    {
                                        tongDiemMay += 1;
                                        Snackbar.make(getView(), "Máy thắng", Snackbar.LENGTH_LONG).show();
                                    }
                                }
                                else
                                {
                                    tongDiemNguoi += 1;
                                    Snackbar.make(getView(), "Bạn thắng", Snackbar.LENGTH_LONG).show();
                                }
                            }
                            else if(KtraBaiDoiCua_May != -1)
                            {
                                if(KtraBaiDoiCua_Nguoi != -1)
                                {
                                    if(KtraBaiDoiCua_Nguoi > KtraBaiDoiCua_May)
                                    {
                                        tongDiemNguoi += 1;
                                        Snackbar.make(getView(), "Bạn thắng", Snackbar.LENGTH_LONG).show();
                                    }
                                    else
                                    {
                                        tongDiemMay += 1;
                                        Snackbar.make(getView(), "Máy thắng", Snackbar.LENGTH_LONG).show();
                                    }
                                }
                                else
                                {
                                    tongDiemMay += 1;
                                    Snackbar.make(getView(), "Máy thắng", Snackbar.LENGTH_LONG).show();
                                }
                            }
                            else
                            {
                                if (Ktra3LaHinhCua_Nguoi > Ktra3LaHinhCua_May)
                                {
                                    tongDiemNguoi += 1;
                                    Snackbar.make(getView(), "Bạn thắng", Snackbar.LENGTH_LONG).show();
                                }
                                else
                                {
                                    tongDiemMay += 1;
                                    Snackbar.make(getView(), "Máy thắng", Snackbar.LENGTH_LONG).show();
                                }
                            }
                        }
                        else
                        {
                            int diem_Nguoi = TinhDiem(baiNguoi1, baiNguoi2, baiNguoi3);
                            txtDiemNguoiChoi.setText("Bạn: " + diem_Nguoi + "điểm");
                            tongDiemMay += 1;
                            Snackbar.make(getView(), "Máy thắng", Snackbar.LENGTH_LONG).show();
                        }
                    }
                    else
                    {
                        int diem_Nguoi = TinhDiem(baiNguoi1, baiNguoi2, baiNguoi3);
                        txtDiemNguoiChoi.setText("Bạn: " + diem_Nguoi + "điểm");
                        txtDiemMay.setText("Máy: " + diem_May + "điểm");
                        if (diem_Nguoi > diem_May)
                        {
                            tongDiemNguoi += 1;
                            Snackbar.make(getView(), "Bạn thắng", Snackbar.LENGTH_LONG).show();
                        }
                        else if (diem_May > diem_Nguoi)
                        {
                            tongDiemMay += 1;
                            Snackbar.make(getView(), "Máy thắng", Snackbar.LENGTH_LONG).show();
                        }
                        else
                        {
                            if(KtraBaiDoiCua_Nguoi != -1)
                            {
                                if(KtraBaiDoiCua_May != -1)
                                {
                                    if(KtraBaiDoiCua_Nguoi > KtraBaiDoiCua_May)
                                    {
                                        tongDiemNguoi += 1;
                                        Snackbar.make(getView(), "Bạn thắng", Snackbar.LENGTH_LONG).show();
                                    }
                                    else
                                    {
                                        tongDiemMay += 1;
                                        Snackbar.make(getView(), "Máy thắng", Snackbar.LENGTH_LONG).show();
                                    }
                                }
                                else
                                {
                                    tongDiemNguoi += 1;
                                    Snackbar.make(getView(), "Bạn thắng", Snackbar.LENGTH_LONG).show();
                                }
                            }
                            else if(KtraBaiDoiCua_May != -1)
                            {
                                if(KtraBaiDoiCua_Nguoi != -1)
                                {
                                    if(KtraBaiDoiCua_Nguoi > KtraBaiDoiCua_May)
                                    {
                                        tongDiemNguoi += 1;
                                        Snackbar.make(getView(), "Bạn thắng", Snackbar.LENGTH_LONG).show();
                                    }
                                    else
                                    {
                                        tongDiemMay += 1;
                                        Snackbar.make(getView(), "Máy thắng", Snackbar.LENGTH_LONG).show();
                                    }
                                }
                                else
                                {
                                    tongDiemMay += 1;
                                    Snackbar.make(getView(), "Máy thắng", Snackbar.LENGTH_LONG).show();
                                }
                            }
                            else
                            {
                                int LaBaiCaoNhatCua_Nguoi = LayLaBaiCaoNhat(baiNguoi1, baiNguoi2, baiNguoi3);
                                int LaBaiCaoNhatCua_May = LayLaBaiCaoNhat(baiMay1, baiMay2, baiMay3);
                                if (LaBaiCaoNhatCua_May > LaBaiCaoNhatCua_Nguoi)
                                {
                                    tongDiemMay += 1;
                                    Snackbar.make(getView(), "Máy thắng", Snackbar.LENGTH_LONG).show();
                                }
                                else
                                {
                                    tongDiemNguoi += 1;
                                    Snackbar.make(getView(), "Bạn thắng", Snackbar.LENGTH_LONG).show();
                                }
                            }
                        }
                    }
                }
                txtKetQua.setText("Kết Quả: \t\t\t\tNgười chơi: " + tongDiemNguoi + "\t\t|\t\t" + " Máy: " + tongDiemMay);
                if(soVan == 20)
                {
                    final AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
                    alertDialog.setTitle("Kết Quả");
                    if(tongDiemNguoi > tongDiemMay)
                        alertDialog.setMessage("Tổng điểm Người: " + tongDiemNguoi + "\nTổng điểm Máy: " + tongDiemMay + "\nKết luận: Bạn thắng");
                    else if(tongDiemMay > tongDiemNguoi)
                        alertDialog.setMessage("Tổng điểm Người: " + tongDiemNguoi + "\nTổng điểm Máy: " + tongDiemMay + "\nKết luận: Máy thắng");
                    else
                        alertDialog.setMessage("Tổng điểm Người: " + tongDiemNguoi + "\nTổng điểm Máy: " + tongDiemMay + "\nKết luận: Hòa");
                    alertDialog.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            imgNguoi1.setImageResource(R.drawable.anhbaiup);
                            imgNguoi2.setImageResource(R.drawable.anhbaiup);
                            imgNguoi3.setImageResource(R.drawable.anhbaiup);
                            imgMay1.setImageResource(R.drawable.anhbaiup);
                            imgMay2.setImageResource(R.drawable.anhbaiup);
                            imgMay3.setImageResource(R.drawable.anhbaiup);
                            soBaiDaLat = 0;
                            img1Click = 0;
                            img2Click = 0;
                            img3Click = 0;
                            btnLatBaiClick = 0;
                            btnChiaBaiClick = 0;
                            tongDiemMay = 0;
                            tongDiemNguoi = 0;
                            soVan = 0;
                            soVanCon = 20;
                            txtSoVanConLai.setText("Còn 20 ván");
                            txtDiemMay.setText("Máy: ");
                            txtDiemNguoiChoi.setText("Bạn: ");
                            txtKetQua.setText("Kết Quả:\t\t\t\t Người chơi: 0 \t\t|\t\t Máy : 0");
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

    public void KetThucGame()
    {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
        alertDialog.setTitle("Kết Quả");
        if(tongDiemNguoi > tongDiemMay)
            alertDialog.setMessage("Tổng điểm Người: " + tongDiemNguoi + "\nTổng điểm Máy: " + tongDiemMay + "\nKết luận: Bạn thắng");
        else if(tongDiemMay > tongDiemNguoi)
            alertDialog.setMessage("Tổng điểm Người: " + tongDiemNguoi + "\nTổng điểm Máy: " + tongDiemMay + "\nKết luận: Máy thắng");
        else
            alertDialog.setMessage("Tổng điểm Người: " + tongDiemNguoi + "\nTổng điểm Máy: " + tongDiemMay + "\nKết luận: Hòa");
        alertDialog.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                imgNguoi1.setImageResource(R.drawable.anhbaiup);
                imgNguoi2.setImageResource(R.drawable.anhbaiup);
                imgNguoi3.setImageResource(R.drawable.anhbaiup);
                imgMay1.setImageResource(R.drawable.anhbaiup);
                imgMay2.setImageResource(R.drawable.anhbaiup);
                imgMay3.setImageResource(R.drawable.anhbaiup);
                soBaiDaLat = 0;
                img1Click = 0;
                img2Click = 0;
                img3Click = 0;
                btnLatBaiClick = 0;
                btnChiaBaiClick = 0;
                tongDiemMay = 0;
                tongDiemNguoi = 0;
                soVan = 0;
                soVanCon = 20;
                txtSoVanConLai.setText("Còn 20 ván");
                txtDiemMay.setText("Máy: ");
                txtDiemNguoiChoi.setText("Bạn: ");
                txtKetQua.setText("Kết Quả:\t\t\t\t Người chơi: 0 \t\t|\t\t Máy : 0");
                AlertDialog dialog = alertDialog.create();
                dialog.dismiss();
            }
        });
        AlertDialog dialog = alertDialog.create();
        dialog.show();
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

    public int KiemTraBaiDoi(LaBai bai1, LaBai bai2, LaBai bai3)
    {
        int id1 = bai1.getId(), id2 = bai2.getId(), id3 = bai3.getId();
        int ktra1 = id1 - id2;
        if(Math.abs(ktra1) == 13 || Math.abs(ktra1) == 26 || Math.abs(ktra1) == 39)
        {
            int max1_2 = Math.max(bai1.getDiem(), bai2.getDiem());
            return max1_2;
        }
        else
        {
            int ktra2 = id1 - id3;
            if(Math.abs(ktra2) == 13 || Math.abs(ktra2) == 26 || Math.abs(ktra2) == 39)
            {
                int max1_3 = Math.max(bai1.getDiem(), bai3.getDiem());
                return max1_3;
            }
            else
            {
                int ktra3 = id2 - id3;
                if(Math.abs(ktra3) == 13 || Math.abs(ktra3) == 26 || Math.abs(ktra3) == 39)
                {
                    int max2_3 = Math.max(bai2.getDiem(), bai3.getDiem());
                    return max2_3;
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
