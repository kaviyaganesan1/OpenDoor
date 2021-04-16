package com.samyugdha.mainactivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class AnagramMain3 extends AppCompatActivity implements View.OnClickListener{
    private TextView wordTv;
    private EditText wordEnteredTv;
    private Button validate, newGame;
    private String wordToFind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anagram3);
        wordTv = (TextView) findViewById(R.id.wordTv);
        wordEnteredTv = (EditText) findViewById(R.id.wordEnteredEt);
        validate = (Button) findViewById(R.id.validate);
        validate.setOnClickListener(this);
        newGame = (Button) findViewById(R.id.newGame);
        newGame.setOnClickListener(this);

        newGame();
    }

    @Override
    public void onClick(View view) {
        if (view == validate) {
            validate();
        } else if (view == newGame) {
            newGame();
        }
    }

    private void validate() {
        String w = wordEnteredTv.getText().toString();

        if (wordToFind.equals(w)) {
            Toast.makeText(this, "Congratulations ! You found the word " + wordToFind, Toast.LENGTH_SHORT).show();
            Intent anagram=new Intent(AnagramMain3.this,Class3q3.class);
            startActivity(anagram);
        } else {
            Toast.makeText(this, "Retry !", Toast.LENGTH_SHORT).show();
        }
    }

    public void newGame()
    {
        wordToFind = Anagram3.randomWord();
        String wordShuffled = Anagram3.shuffleWord(wordToFind);
        wordTv.setText(wordShuffled);
        wordEnteredTv.setText("");
    }
}
