package com.example.swamphack;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static final String AUTHOR_KEY = "author";
    public static final String QUOTE_KEY = "quote";
    public static final String TAG = "Check";

    private TextView mQuoteTextView;

    //private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DocumentReference mDocRef = FirebaseFirestore.getInstance().document("sampleData/inspiration");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mQuoteTextView = findViewById(R.id.textView3);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mDocRef.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                if (value.exists()){
                    String quoteText = value.getString(QUOTE_KEY);
                    String authorText = value.getString(AUTHOR_KEY);
                    mQuoteTextView.setText("\"" + quoteText + "\"----" +authorText);
                }
                else if (error != null)
                {
                    Log.w(TAG, "onEvent: got a exception",error );
                }
            }
        });
    }

    public void fetchQuote(View view){

        mDocRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()){
                    String quoteText = documentSnapshot.getString(QUOTE_KEY);
                    String authorText = documentSnapshot.getString(AUTHOR_KEY);
                    mQuoteTextView.setText("\"" + quoteText + "\"----" +authorText);
                }
            }
        });
    }

    public void saveQuote(View view){
        
        
        EditText quoteView = findViewById(R.id.textView);
        EditText authorView = findViewById(R.id.textView2);
        String quoteText = quoteView.getText().toString();
        String authorText = authorView.getText().toString();

        if (quoteText.isEmpty() || authorText.isEmpty()){return;}

        Map<String,Object> dataToSave = new HashMap<String, Object>();
        dataToSave.put(QUOTE_KEY, quoteText);
        dataToSave.put(AUTHOR_KEY, authorText);
        
        /*// new way
        db.collection("user").add(dataToSave).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Log.d(TAG, "onSuccess: new way to save");
            }
        });*/
        
        // old way
        mDocRef.set(dataToSave).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d(TAG, "onSuccess: success save document!");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "onFailure: not success save document!!!!",e);
            }
        });
    }
}