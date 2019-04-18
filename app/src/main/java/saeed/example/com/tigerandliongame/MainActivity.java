package saeed.example.com.tigerandliongame;

import android.graphics.Color;
import android.media.Image;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static saeed.example.com.tigerandliongame.R.drawable.tiger;


public class MainActivity extends AppCompatActivity {

//boolean click =true;

    boolean isOnclickAttributeAble = true;
    int counter = 0;
    int theSecondTime = 0;
    int theThirdTime ;
    int theFourthTime;

    enum ThePlayer
    {
        Lion, Tiger,Neither
    }

    //create an array for 9 choices that we have for choosing either of the options
    ThePlayer [] playerChoices = new ThePlayer[9];

    //create a two dimensional array for specifying the winner rows and columns
    int [][] winnerRowsAndColumns = {{0,1,2}, {3,4,5}, {6,7,8},{0,3,6}, {1,4,7}, {2,5,8}, {0,4,8},{2,4,6} };

//initialize the enum variable
    ThePlayer currentPlayer = ThePlayer.Lion;

    Button btnReset, btnTest;


    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        btnReset = findViewById( R.id.btnReset );



        final ImageView imgView0  = findViewById( R.id.imgView0 );
        final ImageView imgView1 = findViewById( R.id.imgView1 );
        final ImageView imgView2  = findViewById( R.id.imgView2 );
        final ImageView imgView3 = findViewById( R.id.imgView3 );
        final ImageView imgView4 = findViewById( R.id.imgView4 );
        final ImageView imgView5  = findViewById( R.id.imgView5 );
        final ImageView imgView6 = findViewById( R.id.imgView6 );
        final ImageView imgView7 = findViewById( R.id.imgView7 );
        final ImageView imgView8 = findViewById( R.id.imgView8 );


        btnReset.setVisibility( View.INVISIBLE );

        btnReset.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//
//                imgView0.animate().alpha(0).rotation( -3600 );
//                imgView1.animate().alpha( 0 ).rotation( -3600 );
//                imgView2.animate().alpha( 0 ).rotation( -3600 );
//                imgView3.animate().alpha( 0 ).rotation( -3600 );
//                imgView4.animate().alpha( 0 ).rotation( -3600 );
//                imgView5.animate().alpha( 0 ).rotation( -3600 );
//                imgView6.animate().alpha( 0 ).rotation( -3600 );
//                imgView7.animate().alpha( 0 ).rotation( -3600 );
//                imgView8.animate().alpha( 0 ).rotation( -3600 );

//
//                imgView0.setImageDrawable( null );
//                imgView1.setImageDrawable( null );
//                imgView2.setImageDrawable( null );
//                imgView3.setImageDrawable( null );
//                imgView4.setImageDrawable( null );
//                imgView5.setImageDrawable( null );
//                imgView6.setImageDrawable( null);
//                imgView7.setImageDrawable( null );
//                imgView8.setImageDrawable( null );
//
//
//                imgView0.animate().rotation( -3600 );
//                imgView1.animate().rotation( -3600 );
//                imgView2.animate().rotation( -3600);
//                imgView3.animate().rotation( -3600 );
//                imgView4.animate().rotation( -3600 );
//                imgView5.animate().rotation( -3600 );
//                imgView6.animate().rotation( -3600 );
//                imgView7.animate().rotation( -3600 );
//                imgView8.animate().rotation( -3600 );
//
//
//
//
//
//
//
//                //make the images clickable
//                imgView0.setClickable( true );
//                imgView1.setClickable( true );
//                imgView2.setClickable( true );
//                imgView3.setClickable( true );
//                imgView4.setClickable( true );
//                imgView5.setClickable( true );
//                imgView6.setClickable( true );
//                imgView7.setClickable( true );
//                imgView8.setClickable( true );

                drawableClickableAndAnimate( imgView0 );
                drawableClickableAndAnimate( imgView1 );
                drawableClickableAndAnimate( imgView2 );
                drawableClickableAndAnimate( imgView3 );
                drawableClickableAndAnimate( imgView4 );
                drawableClickableAndAnimate( imgView5 );
                drawableClickableAndAnimate( imgView6 );
                drawableClickableAndAnimate( imgView7 );
                drawableClickableAndAnimate( imgView8 );

//                imageView.setClickable( true );
                               isOnclickAttributeAble =true;

                for (int counter = 0; counter < playerChoices.length; counter++)
                {
                playerChoices[counter]= null;
                }


                counter = 0;

                //make the reset button INVISIBLE

                btnReset.setVisibility( View.INVISIBLE );

            }
        } );

//
//        btnTest.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imgView0.setImageAlpha( 1 );
//            }
//        } );






    }

    public void theImageViewIsTapped(View view) {
        // create an image variable so that you can access the methods in the ImageView class; you may need to cast the view variable
         imageView = (ImageView) view;



         //make the imageView onClickable
        imageView.setClickable( false );

         //create a counter so that you can stop the application after nine clicks

        if (isOnclickAttributeAble) {

            imageView.setClickable( false );

            //find the pushed button via an attribute
            int tag = Integer.parseInt( imageView.getTag().toString() );

            //find out whether each choice us Lion or Tiger or neither
            playerChoices[tag] = currentPlayer;




            // if Tiger, drag Tiger
            if (currentPlayer == ThePlayer.Tiger) {
                imageView.setImageResource( R.drawable.tiger );
                currentPlayer = ThePlayer.Lion;
            }

            //if Lion, drag lion
            else if (currentPlayer == ThePlayer.Lion) {
                imageView.setImageResource( R.drawable.lion );
                currentPlayer = ThePlayer.Tiger;
            }

            //if neither, bring nothing
//
//            if(theSecondTime==0) {
//                imageView.setTranslationX( -2000 );
//            }


            imageView.animate().alpha( 1 ).rotation( 3600 ).setDuration( 1000 );


            //find out who the winner is
            for (int[] row : winnerRowsAndColumns) {
                if (playerChoices[row[0]] == playerChoices[row[1]] && playerChoices[row[1]] == playerChoices[row[2]]) {
                    if (playerChoices[row[0]] != null && playerChoices[row[1]] != null && playerChoices[row[2]] != null) {

                        if(playerChoices[row[0]]==ThePlayer.Lion)
                        Toast.makeText( this, "Congrats!!! The Lion has won the game", Toast.LENGTH_LONG ).show();

                        else
                            Toast.makeText( this,"Congrats!!! The Tiger has won the game", Toast.LENGTH_LONG ).show();



                        //make all the player choices null




                        isOnclickAttributeAble = false;

                        btnReset.setVisibility( View.VISIBLE );




                    }
                }
            }



            counter++;


            if ( counter ==9 && isOnclickAttributeAble!=false)
            {
                isOnclickAttributeAble = false;

                Toast.makeText( this, "Ooops!! no one has won the game", Toast.LENGTH_LONG ).show();

                btnReset.setVisibility( View.VISIBLE );


            }









            //let's create a toast to understand everything is working perfectly fine
//         Toast.makeText( this, "every thind is working perfectly", Toast.LENGTH_SHORT ).show();


        }
    }
    public void drawableClickableAndAnimate(ImageView image)
    {
        image.setClickable( true );
        image.animate().rotation( -3600 );
        image.setImageDrawable( null );

    }

    private void gitHubTest()
    {
        //
    }
}