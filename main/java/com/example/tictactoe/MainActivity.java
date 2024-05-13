package com.example.tictactoe;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView welcome, notify;
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, again;

    static int i = 0;
    static String mark = "";
    static boolean winner = false;
    static int buttonPressed = 1;
    static  String name_x;
    static  String name_y;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        notify = findViewById(R.id.notify);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        again = findViewById(R.id.again);

        Intent intent = getIntent();
        name_x = intent.getStringExtra("player_name_x");
        name_y = intent.getStringExtra("player_name_y");

        ArrayList<ArrayList<Integer>> winList = new ArrayList<>(8);

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        winList.add(list1);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        winList.add(list2);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(7);
        list3.add(8);
        list3.add(9);
        winList.add(list3);

        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(1);
        list4.add(5);
        list4.add(9);
        winList.add(list4);

        ArrayList<Integer> list5 = new ArrayList<>();
        list5.add(3);
        list5.add(5);
        list5.add(7);
        winList.add(list5);

        ArrayList<Integer> list6 = new ArrayList<>();
        list6.add(1);
        list6.add(4);
        list6.add(7);
        winList.add(list6);

        ArrayList<Integer> list7 = new ArrayList<>();
        list7.add(2);
        list7.add(5);
        list7.add(8);
        winList.add(list7);

        ArrayList<Integer> list8 = new ArrayList<>();
        list8.add(3);
        list8.add(6);
        list8.add(9);
        winList.add(list8);

        ArrayList<Integer> playerX = new ArrayList<>(5);
        ArrayList<Integer> playerO = new ArrayList<>(5);


        String[] notifyMsg = {name_x+"'s Turn...\n", name_y+"'s Turn...\n"};


        notify.setText("🎇 Welcome...\n\n"+name_x+" & "+name_y+"\n\n");
        notify.append("🔔 Click Buttons to Acquire positions!\n");

        again.setOnClickListener(v -> {
            i = 0;
            buttonPressed = 1;
            notify.setText("🎇 Welcome...\n\n"+name_x+" & "+name_y+"\n\n");
            notify.append("🔔 Click Buttons to Acquire positions!\n");
            button1.setText("1");
            button2.setText("2");
            button3.setText("3");
            button4.setText("4");
            button5.setText("5");
            button6.setText("6");
            button7.setText("7");
            button8.setText("8");
            button9.setText("9");
            playerX.clear();
            playerO.clear();
            button1.setEnabled(true);
            button2.setEnabled(true);
            button3.setEnabled(true);
            button4.setEnabled(true);
            button5.setEnabled(true);
            button6.setEnabled(true);
            button7.setEnabled(true);
            button8.setEnabled(true);
            button9.setEnabled(true);
            name_x = intent.getStringExtra("player_name_x");
            name_y = intent.getStringExtra("player_name_y");

        });
        button1.setOnClickListener(v -> {
            if (!button1.getText().toString().equals("O") && !button1.getText().toString().equals("X")) {
                if (i % 2 == 0) {
                    mark = "X";
                } else {
                    mark = "O";
                }
                int index = getIndex(i);
                notify.setText(notifyMsg[index]);

                button1.setText(mark);
                if (i % 2 == 0) {
                    playerX.add(1);
                } else {
                    playerO.add(1);
                }
                checkForWinners(i, playerX, playerO, winList);
                i++;
                buttonPressed++;
            } else {
                notify.append("Position is already Taken!\n");
                Toast.makeText(MainActivity.this, "Please, Try Different Place...", Toast.LENGTH_SHORT).show();
            }
        });

        button2.setOnClickListener(v -> {
            if (!button2.getText().toString().equals("O") && !button2.getText().toString().equals("X")) {
                if (i % 2 == 0) {
                    mark = "X";
                } else {
                    mark = "O";
                }
                int index = getIndex(i);
                notify.setText(notifyMsg[index]);

                button2.setText(mark);
                if (i % 2 == 0) {
                    playerX.add(2);
                } else {
                    playerO.add(2);
                }
                checkForWinners(i, playerX, playerO, winList);
                i++;
                buttonPressed++;
            } else {
                notify.append("Position is already Taken!\n");
                Toast.makeText(MainActivity.this, "Please, Try Different Place...", Toast.LENGTH_SHORT).show();
            }

        });

        button3.setOnClickListener(v -> {
            if (!button3.getText().toString().equals("O") && !button3.getText().toString().equals("X")) {
                if (i % 2 == 0) {
                    mark = "X";
                } else {
                    mark = "O";
                }
                int index = getIndex(i);
                notify.setText(notifyMsg[index]);

                button3.setText(mark);
                if (i % 2 == 0) {
                    playerX.add(3);
                } else {
                    playerO.add(3);
                }
                checkForWinners(i, playerX, playerO, winList);
                i++;
                buttonPressed++;
            } else {
                notify.append("Position is already Taken!\n");
                Toast.makeText(MainActivity.this, "Please, Try Different Place...", Toast.LENGTH_SHORT).show();
            }
        });

        button4.setOnClickListener(v -> {
            if (!button4.getText().toString().equals("O") && !button4.getText().toString().equals("X")) {
                if (i % 2 == 0) {
                    mark = "X";
                } else {
                    mark = "O";
                }
                int index = getIndex(i);
                notify.setText(notifyMsg[index]);

                button4.setText(mark);
                if (i % 2 == 0) {
                    playerX.add(4);
                } else {
                    playerO.add(4);
                }
                checkForWinners(i, playerX, playerO, winList);
                i++;
                buttonPressed++;
            } else {
                notify.append("Position is already Taken!");
                Toast.makeText(MainActivity.this, "Please, Try Different Place...", Toast.LENGTH_SHORT).show();
            }

        });

        button5.setOnClickListener(v -> {
            if (!button5.getText().toString().equals("O") && !button5.getText().toString().equals("X")) {
                if (i % 2 == 0) {
                    mark = "X";
                } else {
                    mark = "O";
                }
                int index = getIndex(i);
                notify.setText(notifyMsg[index]);

                button5.setText(mark);
                if (i % 2 == 0) {
                    playerX.add(5);
                } else {
                    playerO.add(5);
                }
                checkForWinners(i, playerX, playerO, winList);
                i++;
                buttonPressed++;
            } else {
                notify.append("Position is already Taken!");
                Toast.makeText(MainActivity.this, "Please, Try Different Place...", Toast.LENGTH_SHORT).show();
            }
        });

        button6.setOnClickListener(v -> {
            if (!button6.getText().toString().equals("O") && !button6.getText().toString().equals("X")) {
                if (i % 2 == 0) {
                    mark = "X";
                } else {
                    mark = "O";
                }
                int index = getIndex(i);
                notify.setText(notifyMsg[index]);

                button6.setText(mark);
                if (i % 2 == 0) {
                    playerX.add(6);
                } else {
                    playerO.add(6);
                }
                checkForWinners(i, playerX, playerO, winList);
                i++;
                buttonPressed++;
            } else {
                notify.append("Position is already Taken!");
                Toast.makeText(MainActivity.this, "Please, Try Different Place...", Toast.LENGTH_SHORT).show();
            }
        });

        button7.setOnClickListener(v -> {

            if (!button7.getText().toString().equals("O") && !button7.getText().toString().equals("X")) {
                if (i % 2 == 0) {
                    mark = "X";
                } else {
                    mark = "O";
                }
                int index = getIndex(i);
                notify.setText(notifyMsg[index]);
                button7.setText(mark);
                if (i % 2 == 0) {
                    playerX.add(7);
                } else {
                    playerO.add(7);
                }
                checkForWinners(i, playerX, playerO, winList);
                i++;
                buttonPressed++;
            } else {
                notify.append("Position is already Taken!");
                Toast.makeText(MainActivity.this, "Please, Try Different Place...", Toast.LENGTH_SHORT).show();
            }
        });

        button8.setOnClickListener(v -> {

            if (!button8.getText().toString().equals("O") && !button8.getText().toString().equals("X")) {
                if (i % 2 == 0) {
                    mark = "X";
                } else {
                    mark = "O";
                }
                int index = getIndex(i);
                notify.setText(notifyMsg[index]);

                button8.setText(mark);
                if (i % 2 == 0) {
                    playerX.add(8);
                } else {
                    playerO.add(8);
                }
                checkForWinners(i, playerX, playerO, winList);
                i++;
                buttonPressed++;
            } else {
                notify.append("Position is already Taken!");
                Toast.makeText(MainActivity.this, "Please, Try Different Place...", Toast.LENGTH_SHORT).show();
            }
        });

        button9.setOnClickListener(v -> {

            if (!button9.getText().toString().equals("O") && !button9.getText().toString().equals("X")) {
                if (i % 2 == 0) {
                    mark = "X";
                } else {
                    mark = "O";
                }
                int index = getIndex(i);
                notify.setText(notifyMsg[index]);

                button9.setText(mark);
                if (i % 2 == 0) {
                    playerX.add(9);
                } else {
                    playerO.add(9);
                }
                checkForWinners(i, playerX, playerO, winList);
                i++;
                buttonPressed++;
            } else {
                notify.append("Position is already Taken!");
                Toast.makeText(MainActivity.this, "Please, Try Different Place...", Toast.LENGTH_SHORT).show();
            }
        });

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                i = 0;
                buttonPressed = 1;
                playerO.clear();
                playerX.clear();
                finish(); // to finish this activity and clear the stack- less data uses of memory, else app might crash at certain time
                Intent backIntent = new Intent(MainActivity.this, UserName.class);
                startActivity(backIntent);
            }
        });
    }

    void winnerDeclaration(ArrayList<Integer> playerList, ArrayList<ArrayList<Integer>> winnerList, String player) {

        for (int i = 0; i < winnerList.size(); i++) {
            int count = 0;
            for (int j = 0; j < playerList.size(); j++) {
                for (int k = 0; k < winnerList.get(i).size(); k++) {
                    if (playerList.get(j).equals(winnerList.get(i).get(k))) {
                        count++;
                        break;
                    }
                }
            }
            if (count == 3) {
                Toast.makeText(this, "Winner Found! \nCongratulations! " + player, Toast.LENGTH_SHORT).show();
                notify.setText("🍁😄 Congratulations! 😄🍁\nWinner Found!" + "\n\n🎇🥳 Well Done: " + player);
                notify.append("\n\n🔔 Press 'Play Again' to Continue!");
                winner = true;
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                button5.setEnabled(false);
                button6.setEnabled(false);
                button7.setEnabled(false);
                button8.setEnabled(false);
                button9.setEnabled(false);
                break;
            }
        }
    }

    int getIndex(int index) {
        int i = 0;
        if (index % 2 == 0)
            i = 1;
        else
            i = 0;
        return i;
    }
    void checkForWinners(int iteration, ArrayList<Integer> playerX, ArrayList<Integer> playerO, ArrayList<ArrayList<Integer>> winList) {
        if (buttonPressed == 9) {
            notify.setText("⚠️ It's A Tie! ⚠️\n");
            notify.append("\n🔔 Press 'Play Again' to Continue!");
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            button5.setEnabled(false);
            button6.setEnabled(false);
            button7.setEnabled(false);
            button8.setEnabled(false);
            button9.setEnabled(false);
        }
        if (playerX.size() >= 3) {
            winnerDeclaration(playerX, winList, name_x);
        }
        if (playerO.size() >= 3) {
            winnerDeclaration(playerO, winList, name_y);
        }
    }


//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        new AlertDialog.Builder(MainActivity.this).setIcon(R.drawable.baseline_warning_24).setTitle("Exit!")
//                .setMessage("Are you Sure ?!! ").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        finish();
//                    }
//                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this, "Thanks For Confirming! ", Toast.LENGTH_SHORT).show();
//                        dialog.dismiss();
//                    }
//                }).setNeutralButton("Help!", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this, "Press Yes to Exit the Application!", Toast.LENGTH_SHORT).show();
//                    }
//                }).show();
//    }

}
