package com.karmug.helpme;

import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Login extends AppCompatActivity
{

    private Cursor cursor;
    private static boolean isLoggedIn;

    public Login()
    {

    }

    public static void setIsLoggedIn(boolean b)
    {
        isLoggedIn = b;
    }

    public boolean checkDetails(EditText etLoginGmail, EditText etLoginPassword, SQLiteDatabase db, Context currentContext)
    {
        String email = etLoginGmail.getText().toString().trim();
        String password = etLoginPassword.getText().toString().trim();
        if (email.isEmpty() || password.isEmpty())
        {
            Toast.makeText(currentContext, "Enter your Email and Password to login", Toast.LENGTH_SHORT).show();
        }
        else
        {
            cursor = db.rawQuery("SELECT *FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.COL_4 + "=? AND " + DatabaseHelper.COL_5 + "=?", new String[]{email, password});
            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    Toast.makeText(currentContext, "Login sucess", Toast.LENGTH_SHORT).show();
                    isLoggedIn = true;
                    return true;

                } else {
                    Toast.makeText(currentContext, "Login error", Toast.LENGTH_SHORT).show();
                    isLoggedIn = false;
                }
            }
        }
        return isLoggedIn;
    }

    public static boolean getIsLoggedIn()
    {
        return isLoggedIn;
    }


}

