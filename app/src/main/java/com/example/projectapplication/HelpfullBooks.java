package com.example.projectapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HelpfullBooks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpfull_books);

        Spinner spinner1 = findViewById(R.id.spnMenu);
        ListView listView = findViewById(R.id.listview);

        String[] categories = new String[] {
                "Calculus Books",
                "PreCalculus Books",
                "Linear Algebra Books",
        };

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        spinner1.setAdapter(adapter1);

        Button btnSearch = findViewById(R.id.btnSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cat = spinner1.getSelectedItem().toString();
                String[] books ;
                if(cat.equals("Calculus Books")){
                    books = new String[] {
                            "Princeton Review AP Calculus AB Premium Prep, 10th Edition",
                            "AP Calculus Premium, 2024",
                            "Essential Calculus Skills Practice Workbook with Full Solutions",
                    };
                } else if (cat.equals("PreCalculus Books")) {
                    books = new String[] {
                            "Barron's Math 360: A Complete Study Guide to Pre-Calculus with Online Practice",
                            "Precalculus: Mathematics for Calculus",
                            "Precalculus, Student Edition",
                    };
                }else{
                    books = new String[] {
                            "Linear Algebra Done Right",
                            "Introduction to Linear Algebra",
                            "Linear Algebra: Theory, Intuition, Code",
                    };
                }
                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(HelpfullBooks.this, android.R.layout.simple_list_item_1, books);
                listView.setAdapter(adapter2);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String cat = spinner1.getSelectedItem().toString();
                if(cat.equals("Calculus Books")){
                    if(position == 0){
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.amazon.com/Princeton-Review-Calculus-Premium-Prep/dp/0593516737/ref=zg_bs_g_13905_d_sccl_1/136-1050186-6002623?psc=1"));
                        startActivity(intent);
                    } else if (position == 1) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.amazon.com/AP-Calculus-Premium-2024-Comprehensive/dp/1506287832/ref=zg_bs_g_13905_d_sccl_2/136-1050186-6002623?psc=1"));
                        startActivity(intent);
                    }else{
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.amazon.com/Essential-Calculus-Practice-Workbook-Solutions/dp/1941691242/ref=zg_bs_g_13905_d_sccl_4/136-1050186-6002623?psc=1"));
                        startActivity(intent);
                    }
                } else if (cat.equals("PreCalculus Books")) {
                    if(position == 0){
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.amazon.com/Barrons-Math-360-Complete-Pre-Calculus/dp/1506281389/ref=sr_1_2_sspa?dib=eyJ2IjoiMSJ9.08-csGaK4LLAPWWDH3tgwz_tIA_-b3FWX9vGU_tUu0pEBTp40cp4jtri2SB0zlLkQIcT_Fzjr__o6_LD2AklmKDuO-FLeUGJKxxYdsZSNUwpIdtmpHEHOrO7F62adguUfMV81GfML3CsViLlQAVqDJBzkUkF_7q2eHtcbDU99flf0CbYUfbvRT4sKUys80wQ3FiS2IwJhh0QTLtSAEkETbI4O_Ln1yxJMK7sKLLmt7napRWHyMAO0ujgFttbd7-KjtjfabCLPL1yHaO21ZcFtH5sYPAFGqkriMJPVtjuN-4.6Cfym4zFVrhqBtQhDeuVpMZVO0DbxGc9KhD9ZqNcqag&dib_tag=se&keywords=Precalculus+Textbook&qid=1713461108&sr=8-2-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&psc=1"));
                        startActivity(intent);
                    } else if (position == 1) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.amazon.com/Precalculus-Mathematics-Calculus-Standalone-Book/dp/1305071751/ref=sr_1_3?dib=eyJ2IjoiMSJ9.08-csGaK4LLAPWWDH3tgwz_tIA_-b3FWX9vGU_tUu0pEBTp40cp4jtri2SB0zlLkQIcT_Fzjr__o6_LD2AklmKDuO-FLeUGJKxxYdsZSNUwpIdtmpHEHOrO7F62adguUfMV81GfML3CsViLlQAVqDJBzkUkF_7q2eHtcbDU99flf0CbYUfbvRT4sKUys80wQ3FiS2IwJhh0QTLtSAEkETbI4O_Ln1yxJMK7sKLLmt7napRWHyMAO0ujgFttbd7-KjtjfabCLPL1yHaO21ZcFtH5sYPAFGqkriMJPVtjuN-4.6Cfym4zFVrhqBtQhDeuVpMZVO0DbxGc9KhD9ZqNcqag&dib_tag=se&keywords=Precalculus+Textbook&qid=1713461108&sr=8-3"));
                        startActivity(intent);
                    }else{
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.amazon.com/Precalculus-Student-ADVANCED-MATH-CONCEPTS/dp/007664183X/ref=sr_1_6?dib=eyJ2IjoiMSJ9.08-csGaK4LLAPWWDH3tgwz_tIA_-b3FWX9vGU_tUu0pEBTp40cp4jtri2SB0zlLkQIcT_Fzjr__o6_LD2AklmKDuO-FLeUGJKxxYdsZSNUwpIdtmpHEHOrO7F62adguUfMV81GfML3CsViLlQAVqDJBzkUkF_7q2eHtcbDU99flf0CbYUfbvRT4sKUys80wQ3FiS2IwJhh0QTLtSAEkETbI4O_Ln1yxJMK7sKLLmt7napRWHyMAO0ujgFttbd7-KjtjfabCLPL1yHaO21ZcFtH5sYPAFGqkriMJPVtjuN-4.6Cfym4zFVrhqBtQhDeuVpMZVO0DbxGc9KhD9ZqNcqag&dib_tag=se&keywords=Precalculus+Textbook&qid=1713461108&sr=8-6"));
                        startActivity(intent);
                    }
                }else{
                    if(position == 0){
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.amazon.com/Linear-Algebra-Right-Undergraduate-Mathematics-ebook/dp/B00PULZWPC/ref=sr_1_1_sspa?dib=eyJ2IjoiMSJ9.Hs8weKJJvKWP9juXi2Zy1RDPsfQy2KCXKJPamc9-t8rFZb56MLavvXX6pCF7tuRoVX2_LWP2xmJNOoBEFvWWnq5Uce1MhXS8owzLoTIxkQOffusxUNltTDHbzs1ewqhEC-J3gKt7t8uVurjt719tl9G2O_zkPqSoQgzYTZ6WOF5sID3iZ5ddLjyGiGGeEZZ4HShqNpQSo5M614DVWD0ktIvpfNpGHAwPhOftj4NTQAtafQkZcu2SkwmnDydDzNV1v6J7uKRZeRdPZtfXoPJDNBFlyptIbhayKqxK1jz8HqQ.q1PV3Zjvu3ki9VaqzmhQBUZ09gt3JKZHq0NQJEVCro4&dib_tag=se&keywords=Linear+Algebra&qid=1713461216&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&psc=1"));
                        startActivity(intent);
                    } else if (position == 1) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.amazon.com/Introduction-Linear-Algebra-Gilbert-Strang/dp/1733146679/ref=sr_1_5?dib=eyJ2IjoiMSJ9.Hs8weKJJvKWP9juXi2Zy1RDPsfQy2KCXKJPamc9-t8rFZb56MLavvXX6pCF7tuRoVX2_LWP2xmJNOoBEFvWWnq5Uce1MhXS8owzLoTIxkQOffusxUNltTDHbzs1ewqhEC-J3gKt7t8uVurjt719tl9G2O_zkPqSoQgzYTZ6WOF5sID3iZ5ddLjyGiGGeEZZ4HShqNpQSo5M614DVWD0ktIvpfNpGHAwPhOftj4NTQAtafQkZcu2SkwmnDydDzNV1v6J7uKRZeRdPZtfXoPJDNBFlyptIbhayKqxK1jz8HqQ.q1PV3Zjvu3ki9VaqzmhQBUZ09gt3JKZHq0NQJEVCro4&dib_tag=se&keywords=Linear+Algebra&qid=1713461216&sr=8-5"));
                        startActivity(intent);
                    }else{
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.amazon.com/Linear-Algebra-Theory-Intuition-Code/dp/9083136604/ref=sr_1_8?dib=eyJ2IjoiMSJ9.Hs8weKJJvKWP9juXi2Zy1RDPsfQy2KCXKJPamc9-t8rFZb56MLavvXX6pCF7tuRoVX2_LWP2xmJNOoBEFvWWnq5Uce1MhXS8owzLoTIxkQOffusxUNltTDHbzs1ewqhEC-J3gKt7t8uVurjt719tl9G2O_zkPqSoQgzYTZ6WOF5sID3iZ5ddLjyGiGGeEZZ4HShqNpQSo5M614DVWD0ktIvpfNpGHAwPhOftj4NTQAtafQkZcu2SkwmnDydDzNV1v6J7uKRZeRdPZtfXoPJDNBFlyptIbhayKqxK1jz8HqQ.q1PV3Zjvu3ki9VaqzmhQBUZ09gt3JKZHq0NQJEVCro4&dib_tag=se&keywords=Linear+Algebra&qid=1713461216&sr=8-8"));
                        startActivity(intent);
                    }
                }
            }
        });

    }

    @Override
    protected void onPause() {//save user state on this activity
        super.onPause();
        Spinner spinner1 = findViewById(R.id.spnMenu);
        SharedPreferences preferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        int spinnerData = spinner1.getSelectedItemPosition();
        editor.putInt("spinnerData",spinnerData);
        editor.commit();
    }

    @Override
    protected  void onStart(){
        super.onStart();
        Spinner spinner1 = findViewById(R.id.spnMenu);
        SharedPreferences preferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);
        int spinnerData = preferences.getInt("spinnerData",0);

        spinner1.setSelection(spinnerData);
    }

    @Override
    protected void onStop(){
        super.onStop();
        SharedPreferences preferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isLoggedIn",true);
        editor.commit();
    }

}