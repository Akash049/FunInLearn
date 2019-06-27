package com.example.administrator.storyapp.Quiz;

import android.widget.Toast;

/**
 * Created by Administrator on 01-07-2016.
 */

public class FillQuestions {
  DataBaseHandler db;

  public FillQuestions(DataBaseHandler db) {
    this.db = db;
    SetQuizQuestions(db);
  }

  private void SetQuizQuestions(DataBaseHandler db) {
    if(db.isEmpty()) {
      /**
       * Adding data to Test table
       */
      db.add_question(new Quiz_Data_Model(1, "Grand Central Terminal, Park Avenue, New York is the world's", "largest railway station", "highest railway station"

        , "longest railway station", "None of the above", "largest railway station", "None", 0));
      db.add_question(new Quiz_Data_Model(2,
        "Entomology is the science that studies", "Behavior of human beings", "Insects"

        , "The origin and history of technical and scientific terms", "The formation of rocks", "Insects", "None", 0));
      db.add_question(new Quiz_Data_Model(3,
        "Eritrea, which became the 182nd member of the UN in 1993, is in the continent of", "Asia", "Africa"

        , "Europe", "Australia", "Africa", "None", 0));
      db.add_question(new Quiz_Data_Model(4,
        "Garampani sanctuary is located at", "Junagarh, Gujarat", "Diphu, Assam"

        , "Kohima, Nagaland", "Gangtok, Sikkim", "Diphu, Assam", "None", 0));
      db.add_question(new Quiz_Data_Model(5,
        "The central banking functions in India are performed by the", "Central Bank of India ", "Reserve Bank of India "

        , "State Bank of India ", "Punjab National Bank", "Reserve Bank of India", "None", 0));
      db.add_question(new Quiz_Data_Model(6,
        "Development expenditure of the Central government does not include", "defence expenditure ", "expenditure on economic services "

        , "expenditure on social and community services ", "grant to states", "defence expenditure", "None", 0));
      db.add_question(new Quiz_Data_Model(7,
        "Gilt-edged market means", "bullion market ", "market of government securities "

        , "market of guns ", "market of pure metals", "market of government securities", "None", 0));
      db.add_question(new Quiz_Data_Model(8,
        "In the last one decade, which one among the following sectors has attracted the highest foreign direct investment inflows into India?", "Food processing ", "Telecommunication "

        , "Chemicals other than fertilizers ", "Services sector", "Telecommunication", "None", 0));
      db.add_question(new Quiz_Data_Model(9,
        "In the second nationalization of commercial banks, ___ banks were nationalized.", "4 ", "5 "

        , "6 ", "8", "6", "None", 0));
      db.add_question(new Quiz_Data_Model(10,
        "If all the banks in an economy are nationalized and converted into a monopoly bank, the total deposits", "will decrease  ", "will increase "

        , "will neither increase nor decrease ", "None of the above", "will neither increase nor decrease", "None", 0));

      /**
       *
       */

      /**
       * Adding data to Economics_Level_1 table
       */
       db.add_Economics_Level_1_question(new Quiz_Data_Model(1,
         "Who was the first administrator-statesman to attempt planning as a means for economic development?", "Sir CP Ramaswami Aiyyar", "M Viswesvarayya"

         , " VT Krishnamachari", "C Rajagopalachari", "M Viswesvarayya", "None", 0));
      db.add_Economics_Level_1_question(new Quiz_Data_Model(2,
        "An economy is at the take off stage on its path to development when it", "becomes stagnant", "begins steady growth"

        , "is liberalized", "gets maximum foreign aid", "begins steady growth", "None", 0));
      db.add_Economics_Level_1_question(new Quiz_Data_Model(3,
        "Which of the following is the basic characteristic of Oligopoly?", "a few sellers, one buyer", "a few sellers, many buyers"

        , "a few sellers, a few buyers", "many sellers, a few buyers", "a few sellers, many buyers", "None", 0));
      db.add_Economics_Level_1_question(new Quiz_Data_Model(4,
        "The aim of which of the Five Year Plans was to correct the disequilibrium in the economy?", "First Five Year Plan", " Second Five Year Plan"

        , "Third Five Year Plan", " Fourth Five Year Plan", "First Five Year Plan", "None", 0));
      db.add_Economics_Level_1_question(new Quiz_Data_Model(5,
        "Which of the following Five Year Plans recognized human development as the core of all developmental efforts?", "Eighth Five Year Plan", "Seventh Five Year Plan"

        , "Fifth Five Year Plan", " Third Five Year Plan", "Eighth Five Year Plan", "None", 0));
      db.add_Economics_Level_1_question(new Quiz_Data_Model(6,
        " Which of the following plans aimed at improving the standard of living?", "Third Plan", "Fourth Plan"

        , "Fifth Plan", "Sixth Plan", " Fourth Plan", "None", 0));
      db.add_Economics_Level_1_question(new Quiz_Data_Model(7,
        "At which of the following places was the mining of coal started in 1774?", "Chhindwara", "Dhanbad"

        , "Ranchi", "Raniganj", " Raniganj", "None", 0));
      db.add_Economics_Level_1_question(new Quiz_Data_Model(8,
        "In which of the following years were the cocking coals and non-cocking coal mines in India nationalized?", "1971 and 1972 repetitively", "1972 and 1973 respectively"

        , "1973 and 1974 respectively", "1970 and 1972 respectively", "1972 and 1973 respectively", "None", 0));
      db.add_Economics_Level_1_question(new Quiz_Data_Model(9,
        "Which Indian state has the largest number of cotton textile mills?", "Madhya Pradesh", "Maharashtra"

        , "Gujarat", "West Bengal", "Maharashtra", "None", 0));
      db.add_Economics_Level_1_question(new Quiz_Data_Model(10,
        "Minor ports like Kakinada, Machilipatnam, Bheemunipatnam and Krishnapatnam are in which of the following states?", "Tamil Nadu", "Andhra Pradesh"

        , "Maharashtra", "Karnataka", "Andhra Pradesh", "None", 0));

      /**
       *
       */
      /**
       * Adding Programming Questions
       */
      db.add_Programming_Level_1_question(new Quiz_Data_Model(1,
        "Who is father of C Language?", "Bjarne Stroustrup", "James A. Gosling"

        , "Dennis Ritchie", "Dr. E.F. Codd", "Bjarne Stroustrup", "None", 0));
      db.add_Programming_Level_1_question(new Quiz_Data_Model(2,
        "C Language developed at _________?", "AT&T's Bell Lab USA,1972", "AT&T's Bell Lab USA,1970"

        , "Sun Microsystems in 1973", "Cambridge University,1972", "AT&T's Bell Lab USA,1972", "None", 0));
      db.add_Programming_Level_1_question(new Quiz_Data_Model(3,
        "For 16-bit compiler allowable range for integer constants is ________?", "-3.4e38 to 3.4e38", "-32767 to 32768"

        , "-32668 to 32667", "-32768 to 32767", "-32768 to 32767", "None", 0));
      db.add_Programming_Level_1_question(new Quiz_Data_Model(4,
        "C programs are converted into machine language with the help of", "An Editor", "A compiler"

        , "An operating system", "None of these.", "A compiler", "None", 0));
      db.add_Programming_Level_1_question(new Quiz_Data_Model(5,
        "C was primarily developed as", "System programming language", "General purpose language"

        , "Data processing language", "None of these.", "System programming language", "None", 0));
      db.add_Programming_Level_1_question(new Quiz_Data_Model(6,
        "Standard ANSI C recognizes ______ number of keywords? ", "30", "24"

        , "36", "32", "32", "None", 0));
      db.add_Programming_Level_1_question(new Quiz_Data_Model(7,
        "Which one of the following is not a reserved keyword for C?", "auto", "case"

        , "main", "default", "main", "None", 0));
      db.add_Programming_Level_1_question(new Quiz_Data_Model(8,
        "A C variable cannot start with", "A number", "special symbol other than '_'"

        , "Both of the above", "An alphabet", "Both of the above", "None", 0));
      db.add_Programming_Level_1_question(new Quiz_Data_Model(9,
        "Which one of the following is not a valid identifier?", "_num", "1num"

        , "nu_m", "num1", "1num", "None", 0));
      db.add_Programming_Level_1_question(new Quiz_Data_Model(10,
        "If integer needs two bytes of storage, then maximum value of an unsigned integer is ", "2^16 – 1", "2^15 – 1"

        , "2^16", "2^15", "2^16 – 1", "None", 0));


    }
    else
    {

    }
  }
}
