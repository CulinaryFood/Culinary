package id.ac.polinema.culinaryfood.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import id.ac.polinema.culinaryfood.R;
import id.ac.polinema.culinaryfood.models.UploadMenu;

public class AddMenuActivity extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;

    private Button mbuttonimage,mbuttonsave;
    private EditText edname,edharga;
    private TextView txtshow;
    private ImageView edimg;
    private Uri mImgUri;
    private ProgressBar mProgressBar;
    private StorageReference mStorageRef;
    private DatabaseReference mdbref;
    private StorageTask mUploadTask;
    String getDownloadURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_menu);

        mbuttonimage = findViewById(R.id.btnpilih);
        mbuttonsave = findViewById(R.id.btnsave);
        edname = findViewById(R.id.name);
        edharga = findViewById(R.id.harga);
        edimg = findViewById(R.id.gambar);
        txtshow = findViewById(R.id.txtshow);
        mProgressBar = findViewById(R.id.progress_bar);
        mStorageRef = FirebaseStorage.getInstance().getReference("uploadmenu");
        mdbref = FirebaseDatabase.getInstance().getReference("uploadmenu");

        mbuttonimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }

        });
        mbuttonsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mUploadTask!=null && mUploadTask.isInProgress()){
                    Toast.makeText(AddMenuActivity.this, "Upload in progress", Toast.LENGTH_SHORT).show();
                }else {
                    uploadFile();
                }

            }
        });
        txtshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    private void openFileChooser() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode ==PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data!=null && data.getData()!=null){
            mImgUri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),mImgUri);
                edimg.setImageBitmap(bitmap);
            }catch (IOException e){
                e.printStackTrace();
            }
//            Picasso.get().load(mImgUri).into(edimg);
//            edimg.setImageURI(mImgUri);

        }
    }
    private String getFileExtension(Uri uri){
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }
    private void uploadFile(){
        if (mImgUri != null){
            StorageReference filereference = mStorageRef.child(System.currentTimeMillis()
            + "." + getFileExtension(mImgUri) );
            mUploadTask = filereference.putFile(mImgUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {

                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    mProgressBar.setProgress(0);
                                }
                            },500);
                            Toast.makeText(AddMenuActivity.this,"Upload successfull",Toast.LENGTH_LONG).show();
                            UploadMenu uploadMenu = new UploadMenu(edname.getText().toString().trim(),edharga.getText().toString().trim(),
                                    taskSnapshot.getStorage().getDownloadUrl().toString());
                            String uploadId = mdbref.push().getKey();
                            mdbref.child(uploadId).setValue(uploadMenu);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(AddMenuActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                            mProgressBar.setProgress((int)progress);
                        }
                    });
        }else {
            Toast.makeText(this,"No file selected",Toast.LENGTH_SHORT).show();
        }

    }
}
