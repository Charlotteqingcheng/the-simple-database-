package com.example.litepaltest3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

//新建表的属性直接private 或public 。。。新建表直接class tablename 并在litepal.xml里填东西
class Book extends DataSupport {private String press; private int id; private String author; private double price; private int pages; private String name; public String getPress() { return press; }public int getId() { return id; }public void setPress(String press) { this.press = press; }public void setId(int id) { this.id = id; }public String getAuthor() { return author; }public void setAuthor(String author) { this.author = author; }public double getPrice() { return price; }public void setPrice(double price) { this.price = price; }
    public int getPages() { return pages; }public void setPages(int pages) { this.pages = pages; }public String getName() { return name; }public void setName(String name) { this.name = name; } }
 class Category { private int id; private String categoryName; private int categoryCode; public void setId(int id) { this.id = id; }public void setCategoryName(String categoryName) { this.categoryName = categoryName; }public void setCategoryCode(int categoryCode) { this.categoryCode = categoryCode; } }
    public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button createDatabase = (Button) findViewById(R.id.create_database); createDatabase.setOnClickListener(new View.OnClickListener() { @Override public void onClick(View v) { LitePal.getDatabase(); } });
        Button addData = (Button) findViewById(R.id.add_data); addData.setOnClickListener(new View.OnClickListener() { @Override public void onClick(View v) { Book book = new Book(); book.setName("The Da Vinci Code"); book.setAuthor("Dan Brown"); book.setPages(454); book.setPrice(16.96); book.setPress("Unknow"); book.save(); } });
        Button updateData = (Button) findViewById(R.id.update_data); updateData.setOnClickListener(new View.OnClickListener() { @Override public void onClick(View v) {Book book = new Book(); book.setToDefault("pages"); book.updateAll();  } });
        Button deleteButton = (Button) findViewById(R.id.delete_data); deleteButton.setOnClickListener(new View.OnClickListener() { @Override public void onClick(View v) { DataSupport.deleteAll(Book.class, "price < ?", "15"); } });
        Button queryButton = (Button) findViewById(R.id.query_data); queryButton.setOnClickListener(new View.OnClickListener() { @Override public void onClick(View v) { List<Book> books = DataSupport.findAll(Book.class); for (Book book: books) { Log.d("MainActivity", "book name is " + book.getName()); Log.d("MainActivity", "book author is " + book.getAuthor()); Log.d("MainActivity", "book pages is " + book.getPages()); Log.d("MainActivity", "book price is " + book.getPrice());
            Log.d("MainActivity", "book press is " + book.getPress()); } } });
    }
}
