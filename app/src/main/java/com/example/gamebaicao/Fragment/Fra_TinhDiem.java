package com.example.gamebaicao.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.google.android.material.snackbar.Snackbar;

import com.example.gamebaicao.R;

import java.util.ArrayList;
import java.util.Random;

public class Fra_TinhDiem extends Fragment {

    ImageView [] laBai = new ImageView[3];
    Button btnRutBai;

    ArrayList<LaBai> lstDSBai = new ArrayList<LaBai>();
    int tongDiem = 0;
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
        view = inflater.inflate(R.layout.activity_fra__tinh_diem,container, false);
        ConnectView();
        setDuLieuBai();
        btnRutBai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chiaBai();
            }
        });
        return view;
    }

    void ConnectView()
    {
        laBai[0] = (ImageView) view.findViewById(R.id.imgLaBai1);
        laBai[1] = (ImageView) view.findViewById(R.id.imgLaBai2);
        laBai[2] = (ImageView) view.findViewById(R.id.imgLaBai3);
        btnRutBai = (Button) view.findViewById(R.id.btnRutBai);
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
        int bai1 = random.nextInt(52) + 1;
        int bai2 = random.nextInt(52) + 1;
        while(true)
        {
            if(bai1 != bai2)
                break;
            else
                bai2 = random.nextInt(52) + 1;
        }

        int bai3 = random.nextInt(52) + 1;
        while (true)
        {
            if(bai1 != bai3 && bai2 != bai3)
                break;
            else
                bai3 = random.nextInt(52) + 1;
        }

        final LaBai labai1 = getLaBaiById(bai1);
        final LaBai labai2 = getLaBaiById(bai2);
        final LaBai labai3 = getLaBaiById(bai3);
        laBai[0].setImageResource(labai1.getHinh());
        laBai[1].setImageResource(labai2.getHinh());
        laBai[2].setImageResource(labai3.getHinh());
        String ketQua = "";
        if(KiemTraBaLaTrungNhau(labai1, labai2, labai3))
            ketQua = "Ba Lá trùng nhau";
        else if(KiemTraBaHinh(labai1, labai2, labai3))
            ketQua = "Ba Lá hình";
        else
        {
            tongDiem = TinhDiem(labai1, labai2, labai3);
            ketQua = tongDiem + " Điểm";
        }
        Snackbar.make(getView(), "Kết quả của 3 lá bài là: " + ketQua, Snackbar.LENGTH_LONG).show();
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

    public boolean KiemTraBaHinh(LaBai bai1, LaBai bai2, LaBai bai3)
    {
        if((bai1.getId() > 10 && bai1.getId() <= 13) || (bai1.getId() > 23 && bai1.getId() <= 26) || (bai1.getId() > 36 && bai1.getId() <= 39) || (bai1.getId() > 49 && bai1.getId() <= 52))
        {
            if((bai2.getId() > 10 && bai2.getId() <= 13) || (bai2.getId() > 23 && bai2.getId() <= 26) || (bai2.getId() > 36 && bai2.getId() <= 39) || (bai2.getId() > 49 && bai2.getId() <= 52))
            {
                if((bai3.getId() > 10 && bai3.getId() <= 13) || (bai3.getId() > 23 && bai3.getId() <= 26) || (bai3.getId() > 36 && bai3.getId() <= 39) || (bai3.getId() > 49 && bai3.getId() <= 52))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean KiemTraBaLaTrungNhau(LaBai bai1, LaBai bai2, LaBai bai3)
    {
        int id1 = bai1.getId(), id2 = bai2.getId(), id3 = bai3.getId();
        int ktra1 = id1 - id2;
        if(Math.abs(ktra1) == 13 || Math.abs(ktra1) == 26 || Math.abs(ktra1) == 39)
        {
            int ktra2 = id1 - id3;
            if(Math.abs(ktra2) == 13 || Math.abs(ktra2) == 26 || Math.abs(ktra2) == 39)
            {
                return true;
            }
        }
        return false;
    }
}
