package com.example.emailsend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //send();
        Button btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send();
            }
        });


    }

    private void send() {
        String fromEmail = "from@gmail.com", fromPassword = "password", emailSubject = "Test", emailBody = "Test email";
        List toEmailList = new ArrayList();
        toEmailList.add("to@gmail.com");

        GMail gMail = new GMail(fromEmail, fromPassword, toEmailList, emailSubject, emailBody);
        try {
            MimeMessage mimeMessage = gMail.createEmailMessage();
            gMail.sendEmail();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
