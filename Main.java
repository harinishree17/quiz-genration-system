package finale;

import java.util.Scanner;

public class Main {
    int total_teachers = 100, total_students = 200, total_guest = 300, total_category = 400, total_quiz = 0 ;
    
   
    public static void main(String[] args) {
        int menu_choice, category_choice ;
        int total_users = 0;
        Scanner in = new Scanner(System.in);
        Main temp = new Main();
        teachers object_array[] = new teachers[1000];
        guest obj_arr[] = new guest[1000];
        category_quiz objarr[] = new category_quiz[1000];
        students obar[] = new students[1000];
        quiz oa[] = new quiz[1000];
        students s = new students();
        teachers t = new teachers();
        search pol = new search();
        do {
            System.out.println("*********************** Welcome **********************");
            System.out.println("MENU : \n 1. Teacher \n 2. Student \n 3. New Account \n 4. Guest \n 5. Category Quiz \n 6. Exit");
            System.out.println("Enter the option number :");
            menu_choice = in.nextInt();
            switch (menu_choice) {
                case 1:
                    System.out.println("Enter your login id :");
                    int jh = in.nextInt();
                    System.out.println("Enter your password pin :");
                    int ph = in.nextInt();
                    int y[] = t.check(jh,ph,temp.total_teachers, object_array);
                    while(y[0] == 2){
                        System.out.println("Enter your password pin :");
                        ph = in.nextInt();
                        y = t.check(jh,ph, temp.total_teachers, object_array);
                    }
                    if(y[0] == 0)
                        break;
                    if( y[0] == 1) {
                        int teacher_choice;
                        do {
                            System.out.println(" \n MENU : \n 1. Create quiz \n 2. Quizs already conducted \n 3. Result of a particular quiz \n 4.Exit \n Enter your option :");
                            teacher_choice = in.nextInt();
                            switch (teacher_choice) {
                                case 1 : 
                                    System.out.println("\nChoose a option :\n 1. New Quiz \n 2. Reuse a Quiz \n 3. Exit");
                                    int hui = in.nextInt();
                                    create_quiz cq = new create_quiz();
                                    switch (hui) {
                                        case 1:
                                            cq.newquiz(oa, temp.total_quiz);
                                            object_array[y[1]].quiz_created[t.nofq] = Integer.toString(temp.total_quiz);
                                            object_array[y[1]].nofq++;
                                            t.nofq++;
                                            temp.total_quiz++;
                                            break;
                                        case 2:
                                            cq.reuse(oa, object_array, jh, temp.total_quiz);
                                            object_array[y[1]].quiz_created[t.nofq] = Integer.toString(temp.total_quiz);
                                            object_array[y[1]].nofq++;
                                            t.nofq++;
                                            temp.total_quiz++;
                                            break;
                                        case 3:
                                            break;
                                        default : System.out.println("Please do enter the correct option !! ");
                                    }
                                    break;
                                case 2 : 
                                    System.out.println(" The quiz codes created by you are (quiz codes will appear) :");
                                    for (int hj = 0; hj < 1000; hj++) {
                                        if (object_array[y[1]].quiz_created[hj] != null) {
                                            System.out.println(object_array[y[1]].quiz_created[hj]);
                                        }
                                    }
                                    break;
                                case 3 : 
                                    System.out.println(" Enter the quiz code :");
                                    int iku = in.nextInt();
                                    int yht = pol.quiz_search(iku, oa);
                                    if(yht == -1 ){
                                        System.out.println(" No such quiz was created !!");
                                        break;
                                    }
                                    else {
                                        System.out.println(" Participants       Marks   ");
                                        for( int huyj = 0; huyj < oa[yht].nop; huyj ++){
                                            System.out.println("\n "+oa[yht].participants[huyj][0]+"      "+oa[yht].participants[huyj][1]);
                                        }
                                    }
                                    break;
                            }
                        }while(teacher_choice != 4);
                    }
                    break;
                case 2:
                    System.out.println("Enter your login id :");
                    int jw = in.nextInt();
                    System.out.println("Enter your password pin :");
                    int pw = in.nextInt();
                    int c[] = s.check(jw,pw,temp.total_students,obar);
                    while(c[0] == 2){
                        System.out.println("Enter your password pin :");
                        pw = in.nextInt();
                        c = s.check(jw,pw,temp.total_students,obar);
                    }
                    if(c[0] == 0)
                        break;
                    if( c[0] == 1) {
                        int student_choice;
                        do {
                            System.out.println(" \n MENU : \n 1. Attend a quiz \n 2. Attended quizes \n 3. View score level \n 4. Exit\n Enter your option :");
                            student_choice = in.nextInt();
                            switch (student_choice) {
                                case 1 :
                                    System.out.println("Enter the quiz code :");
                                    int yhu = in.nextInt();
                                    int klo= 0, jai =0;
                                    for( int i = 0; i < 1000; i++){
                                        if(yhu == oa[i].id){
                                            klo = 1;
                                            jai = i;
                                            break;
                                        }
                                    }
                                    if(klo == 0){
                                        System.out.println("No such quiz exists !! Enter the code correctly !");
                                        break;
                                    }
                                    else{
                                        play tyu = new play();
                                        int ov = tyu.quizs(yhu,jai,oa);
                                        int q_id = pol.quiz_search(yhu, oa);
                                        oa[q_id].participants[oa[q_id].nop][0]=Integer.toString(jw);
                                        oa[q_id].participants[oa[q_id].nop][1]= Integer.toString(ov);
                                        int yuh = pol.student_search(jw, obar);
                                        obar[yuh].quiz_attended[s.nofq] = Integer.toString(yhu);
                                        oa[q_id].nop++;
                                        s.nofq++;
                                    }
                                    break;
                                case 2 :
                                    int opli = pol.student_search(jw, obar);
                                    System.out.println("The quizes attended by you are (quiz codes will appear) :");
                                    for (int hj = 0; hj < 1000; hj++) {
                                        if (obar[c[1]].quiz_attended[hj] != null) {
                                            System.out.println(obar[c[1]].quiz_attended[hj]);
                                        }
                                    }
                                    break;
                                case 3 :
                                    System.out.println(" Enter the quiz code for which score must be viewed :");
                                    int iku = in.nextInt();
                                    int yht = pol.quiz_search(iku, oa);
                                    if(yht == -1 ){
                                        System.out.println(" No such quiz was created !!");
                                        break;
                                    }
                                    else {
                                        int ert = pol.quizpart_search(jw,iku,oa);
                                        if (ert == -1) {
                                            System.out.println(" You have not participated in that quiz !!");
                                            break;
                                        }
                                        else{
                                            System.out.println(" Your mark in the quiz : "+iku+" is : "+oa[yht].participants[ert][1]);
                                        }
                                    }
                                    break;
                                case 4 :
                                    break;
                                default : System.out.println("Please do enter the correct option !!");    
                            }
                        }while (student_choice != 4) ;
                    }
                    break;
                case 3:
                    int g =0, temporary;
                    System.out.println("You are a ? \n 1. Teacher \n 2. Student \n 3. Exit \n Enter the option : ");
                    int new_choice = in.nextInt();
                    if(new_choice == 1) {
                        int h = temp.total_teachers;
                        System.out.println("Your teacher's id is generted. Your id is : " + h);
                        do {
                            System.out.println("\n Enter a pin for your account (only 4 integer values) :");
                            temporary = in.nextInt();
                            if (temporary > 9999 || temporary < 1000) {
                                g = 1;
                                System.out.println(" The pin must be 4 integers only !! Enter the pin correctly !!");
                            }
                        }while ( g == 1);
                        int hu = temporary;
                        object_array[temp.total_teachers] = new teachers(h,hu);
                        System.out.println(" Your teachers's account was successfully created!! ");
                        temp.total_teachers ++;
                    }
                    if(new_choice == 2) {
                        int jui = temp.total_students;
                        System.out.println("Your student's id is generted. Your id is : " + jui);
                        do {
                            System.out.println("\n Enter a pin for your account (only 4 integer values) :");
                            temporary = in.nextInt();
                            if (temporary > 9999 || temporary < 1000) {
                                g = 1;
                                System.out.println(" The pin must be 4 integers only !! Enter the pin correctly !!");
                            }
                        }while ( g == 1);
                        int juy = temporary;
                        obar[temp.total_students] = new students(jui,juy);
                        System.out.println(" Your student's account was successfully created!!");
                        temp.total_students ++;
                    }
                    if(new_choice == 3) {
                        break;
                    }
                    if(new_choice > 3){
                        System.out.println(" Enter the correct choice !!");
                    }
                    break;
                case 4:
                    int guest_choice;
                    do {
                        System.out.println("Welcome !! \n 1. Attend a quiz \n 2. Exit \n Enter you choice :");
                        guest_choice = in.nextInt();
                        if (guest_choice == 1) {
                            System.out.println("Enter the quiz id :");
                            int temp_qid = in.nextInt();
                            int o =0;
                            for (int i = 0; i < temp.total_quiz; i++) {
                                if (oa[i].id == temp_qid) {
                                    int hai = 0;
                                    System.out.println("Enter your name : ");
                                    String gty = in.nextLine();
                                    in.nextLine();
                                    int gtr = temp.total_guest;
                                    String gth = Integer.toString(temp_qid);
                                    int huj = pol.quiz_search(temp_qid,oa);
                                    oa[huj].participants[oa[huj].nop][0] = Integer.toString(gtr);
                                    quiz p = new quiz();
                                    int gtd = p.quiz(temp_qid,hai, oa);
                                    oa[huj].participants[oa[huj].nop][1] = Integer.toString(gtd);
                                    oa[huj].nop++;
                                    obj_arr[temp.total_guest] = new guest(gtr, gty, gtd, gth);
                                    temp.total_guest ++;
                                    o = 1;
                                }
                            }
                            if(o != 1){
                                System.out.println("There is no such quiz !!");
                            }
                            if(guest_choice > 2){
                                System.out.println("Please enter the correct option !!");
                            }
                        }
                    }while(guest_choice != 2);
                    break;
                case 5:
                    System.out.println("Categories: \n 1. Politics \n 2. GK \n 3. Food \n 4. Moral \n 5. Famous Personalities \n 6. Exit \n Enter your category choice :");
                    category_choice = in.nextInt();
                    while(category_choice!=6){
                        category_quiz ip = new category_quiz();
                        ip.questions_declaration();
                        System.out.println("Enter your name :");
                        String ju = in.nextLine();
                        in.nextLine();
                        objarr[temp.total_category] = new category_quiz(ju);
                        ip.questions(category_choice);
                        System.out.println("Categories: \n 1. Politics \n 2. GK \n 3. Food \n 4. Moral \n 5. Famous Personalities \n 6. Exit \n Enter your category choice :");
                        category_choice = in.nextInt();
                    }
                    if(category_choice > 6){
                        System.out.println("Please do enter the correct optio !!");
                    }
                    break;
                case 6 :
                    break;
                default:
                    System.out.println("Please do enter the correct option !!");
            }
        }while(menu_choice != 6);
    }
}

class category_quiz extends Main{
    int id;
    String[][] questions = new String[25][6];
    String[][] participants = new String[1000][3];
    Scanner in = new Scanner(System.in);
    category_quiz (String ju){
        participants[total_category][0] = ju;
    }
    category_quiz (){

    }
    void questions_declaration(){
        questions[0][0] =  "Abdul Kalam Azad became the __ President of India.";
        questions[0][1] = "9th";
        questions[0][2] = "10th";
        questions[0][3] = "11th";
        questions[0][4] = "12th";
        questions[0][5] = "3";
        questions[1][0] = " The 13th Prime Minister of India was";
        questions[1][1] = "Atal Bihari Vajpayee";
        questions[1][2] = "I.K. Gujral";
        questions[1][3] = "Dr. Manmohan Singh";
        questions[1][4] = "P. V. Narasimha Rao";
        questions[1][5] = "1";
        questions[2][0] = " Who was the President of the Constitutional Committee and played an important role in drafting the Constitution?";
        questions[2][1] = "Dr. B.R. Ambedkar";
        questions[2][2] = "Mahatma Gandhi";
        questions[2][3] = "Both A & B";
        questions[2][4] = "None";
        questions[2][5] = "1";
        questions[3][0] = " Who prevailed in the 1977 elections and ended Indira Gandhi’s emergency rule?";
        questions[3][1] = "Atal Bihari Vajpayee";
        questions[3][2] = "Morarji Desai";
        questions[3][3] = "Charan Singh";
        questions[3][4] = "Lal Bahudar Shastri";
        questions[3][5] = "2";
        questions[4][0] = " Who among the following assassinated Mahatma Gandhi?";
        questions[4][1] = "Karamchand";
        questions[4][2] = "Nathuram Godse";
        questions[4][3] = "Ashfaquallah Khan";
        questions[4][4] = "None of the Above";
        questions[4][5] = "2";
        questions[5][0] = "Which of the following is the capital of Arunachal Pradesh?";
        questions[5][1] = "Itanagar";
        questions[5][2] = "Dispur";
        questions[5][3] = "Panaji";
        questions[5][4] = "Imphal";
        questions[5][5] = "1";
        questions[6][0] =  "Corey Anderson who has hit the fastest ODI century in 36 balls is from";
        questions[6][1] = "England";
        questions[6][2] = "Australia";
        questions[6][3] = "West Indies";
        questions[6][4] = "New Zealand";
        questions[6][5] = "4";
        questions[7][0] = " Who was the first female to become the governor of an Indian state?";
        questions[7][1] = "Subba Lakshmi";
        questions[7][2] = "Padmaja Naidu";
        questions[7][3] = "Sarojini Naidu";
        questions[7][4] = "Vijaya Lakshmi Pandit";
        questions[7][5] = "3";
        questions[8][0] ="The world smallest country is___";
        questions[8][1] ="Maldives";
        questions[8][2] ="Vatican City";
        questions[8][3] ="Russia";
        questions[8][4] ="Canada";
        questions[8][5] ="2";
        questions[9][0] ="The currency notes are printed in___";
        questions[9][1] = "New Delhi";
        questions[9][2] = "Nagpur";
        questions[9][3] = "Nasik";
        questions[9][4] = "Bombay";
        questions[9][5] = "3";
        questions[10][0] ="Durand Cup is associated with the game of__";
        questions[10][1] = "Football";
        questions[10][2] ="Cricket";
        questions[10][3] ="Volleyball";
        questions[10][4] ="Hockey";
        questions[10][5] ="1";
        questions[10][0] = "Which is the national food of India? ";
        questions[10][1] = "Khichdi";
        questions[10][2] = "Roti";
        questions[10][3] = "idli";
        questions[10][4] = "None of these";
        questions[10][5] ="1";
        questions[11][0] = "What oil is used for cooking in South India ? ";
        questions[11][1] = "Coconut oil";
        questions[11][2] = "Sunflower Oil";
        questions[11][3] = "Olive Oil";
        questions[11][4] = "None of these";
        questions[11][5] ="1";
        questions[12][0] = "Which is the national vegetable of India ?";
        questions[12][1] = "lady’s-finger ";
        questions[12][2] = "Brinjal";
        questions[12][3] = "Meetha Kaddu";
        questions[12][4] = "None of these";
        questions[12][5] = "3" ;
        questions[13][0] = " Which Vitamins are rich in Carrots? ";
        questions[13][1] = "Vitamin A ";
        questions[13][2] = "Vitamin K1";
        questions[13][3] = " Vitamin B6 ";
        questions[13][4] ="All of the above";
        questions[13][5] = "4" ;
        questions[14][0] = "Lectin protein is found in __. ";
        questions[14][1] = "Wheat ";
        questions[14][2] = " Rice ";
        questions[14][3] = " Milk";
        questions[14][4] = "None of these";
        questions[14][5] = "1" ;
        questions[15][0] = "A stitch in time...";
        questions[15][1] = "saves nine";
        questions[15][2] = "according to your cloth";
        questions[15][3] = "keeps you in line";
        questions[15][4] = "no moss";
        questions[15][5] = "1" ;
        questions[16][0] = " A _ tongue makes a wise head. ";
        questions[16][1] = "thick";
        questions[16][2] ="still ";
        questions[16][3] = "forked";
        questions[16][4] = "none of the above ";
        questions[16][5] = "2" ;
        questions[17][0] = "You cannot make _ without breaking eggs. ";
        questions[17][1] = " a pancake ";
        questions[17][2] = "noodles";
        questions[17][3] = "an omelette";
        questions[17][4] = "custard";
        questions[17][5] = "3" ;
        questions[18][0] = "The _ path is the safest.";
        questions[18][1] = "beaten";
        questions[18][2] = " widest ";
        questions[18][3] = "lighted";
        questions[18][4] = "bright";
        questions[18][5] = "1";
        questions[19][0] = "_ men find the most time.";
        questions[19][1] = " Laziest ";
        questions[19][2] = "Busiest  ";
        questions[19][3] = " Wise ";
        questions[19][4] = "great ";
        questions[19][5] = "2";
        questions[20][0] ="Who became the first woman to reach the summit of Mount Everest, and the first woman to ascend all Seven Summits by climbing the highest peak on every continent?";
        questions[20][1] = "Junko Tabei";
        questions[20][2] = "Bachendri Pal";
        questions[20][3] = "Santosh yadav";
        questions[20][4] = "Premlata Agarwal";
        questions[20][5] = "1";
        questions[21][0] ="In what year did Sonia Gandhi received Citizenship of India?";
        questions[21][1] = "1984";
        questions[21][2] = "1982";
        questions[21][3] = "1981";
        questions[21][4] = "1989";
        questions[21][5] = "1";
        questions[22][0] =" Who is known as Indian Bismarck?";
        questions[22][1] = "Patel";
        questions[22][2] = "kamaraj";
        questions[22][3] = "Nehru";
        questions[22][4] = "Gandhi";
        questions[22][5] = "1";
        questions[23][0] =" Late Girilal Jain was a noted figure in which of the following fields?";
        questions[23][1] = "Social Service";
        questions[23][2] = "Journalism";
        questions[23][3] = "Sports";
        questions[23][4] = "Politics";
        questions[23][5] = "2";
        questions[24][0] ="Who is called the Flying Sikh of India?";
        questions[24][1] = "Milka Singh";
        questions[24][2] = " Ajit Pal Singh";
        questions[24][3] = "Mohinder Singh";
        questions[24][4] = "Mahendra Singh";
        questions[24][5] = "1";
    }
    void questions (int category_choice){
        int s = 0, e = 0;
        switch (category_choice) {
            case 1 : 
                s = 0;
                e = 5;
                break;
            case 2 : 
                s = 5;
                e = 10;
                break;
            case 3 : 
                s = 10;
                e = 15;
                break;
            case 4 : 
                s = 15;
                e = 20;
                break;
            case 5 : 
                s = 20;
                e = 25;
                break;
        }
        int mark = 0;
        for(int i = s; i < e; i++){
            System.out.println("\n"+(i+1)+". "+questions[i][0]);
            for ( int t = 1 ; t < 5 ; t++){
                if(questions[i][t] != null)
                System.out.println("\n " + t +". "+ questions[i][t]);
            }
            System.out.println("Enter the option number : ");
            int option = in.nextInt();
            if(option == Integer.parseInt(questions[i][5])){
                System.out.println("The answer you entered is correct !!");
                mark = mark + 100;
            }
            else {
                int j = Integer.parseInt(questions[i][5]);
                System.out.println("The answer you entered is wrong !!\n The correct option is : " +j+"\n The correct answer is : "+questions[i][j]);
            }
        }
        mark = mark/5;
        System.out.println(" \n\n  YOUR TOTAL SCORE IS : "+ mark);
        participants[total_category][1] = Integer.toString(mark);
        total_category++;
    }
}

class guest{
    int id;
    String name = new String();
    String quiz_attended = new String();
    int mark;
    guest(int id, String name, int mark, String quiz){
        this.id = id;
        this.name = name;
    }
    guest(){

    }
}

class teachers {
    int id ;
    int pin;
    String[] quiz_created = new String[1000];
    int nofq = 0;
    teachers(int id, int pin){
        this.id = id;
        this.pin = pin;
    }
    teachers(){

    }
    int[] check(int id, int pin, int limit, teachers[] object_array){
        int iou = 0, pass;
        int[] out = new int[2];
        out[1] = -1;
        for(int i = 100; i < limit; i++){
            if(object_array[i].id == id){
                iou = 1;
                if(object_array[i].pin == pin){
                    System.out.println("You have logged in successfully !!");
                    out[0] = 1;
                    out[1] = i;
                }
                else {
                    System.out.println("Your password is incorrect !!");
                    out[0] = 2;
                }
            }
        }
        if(iou != 1) {
            System.out.println("No such teacher's id exist !!");
            out[0] = 0;
        }
        return  out;
    }
}

class students{
    int id;
    int pin = 0;
    String[] quiz_attended = new String[1000];
    int nofq = 0;
    students(int id, int pin){
        this.id = id;
        this.pin = pin;
    }
    students(){

    }
    int[] check(int id, int pin,int limit, students[] obar){
        int iou = 0, pass;
        int[] out = new int[2];
        out[1] = -1;
        for(int i = 200; i < limit; i++){
            if(obar[i].id == id){
                iou = 1;
                if(obar[i].pin == pin){
                    System.out.println("You have logged in successfully !!");
                    out[0] = 1;
                    out[1] = i;
                }
                else {
                    System.out.println("Your password is incorrect !!");
                    out[0] = 2;
                }
            }
        }
        if(iou != 1) {
            System.out.println("No such student's id doesn't exist !!");
            out[0] = 0;
        }
        return  out;
    }
}

class quiz{
    int id;
    int noq;
    int nop;
    String[][] questions = new String[10][6];
    String[][] participants = new String[1000][2];
    public void quizt(int y, int e){
        noq = y;
        id = e;
        for(int i = 0; i< 10; i++){
            for(int j = 0; j< 6; j++){
                questions[i][j] = new String();
            }
        }
    }
    int quiz(int qid,int hai, quiz[] oa){
        play p = new play();
        return (p.quizs(qid,hai, oa));
    }
}

class play extends Main{
    Scanner in = new Scanner(System.in);
    int quizs(int qid,int ind, quiz[] oa){
        int h = ind;
        int mark = 0;
        for(int j = 0; j < oa[ind].noq ; j++){
            System.out.println("\n"+(j+1)+". "+oa[h].questions[j][0]);
            for(int po =1; po< 5; po++){
                System.out.println("\n"+po+". "+oa[h].questions[j][po]);
            }
            System.out.println("Enter the option number : ");
            int optio = in.nextInt();
            if(optio == Integer.parseInt(oa[h].questions[j][5])){
                System.out.println("The answer you enterd is correct !!");
                mark = mark + 100;
            }
            else {
                int ki = Integer.parseInt(oa[h].questions[j][5]);
                System.out.println("The answer you entered is wrong !!\n The correct option is : " +ki+"\n The correct answer is : "+oa[h].questions[j][ki]);
            }
        }
        mark = mark/oa[ind].noq;
        System.out.println(" The marks you have obtained is : "+ mark);
        return mark;
    }
}

class create_quiz extends search{
    Scanner in = new Scanner(System.in);
    int newquiz(quiz[] oa, int index){
        System.out.println("\n Enter the number of questions : ");
        int noq = in.nextInt();
        oa[index] = new quiz();
        String qu[][] = new String[5][6];
        for ( int i = 0; i < noq ; i++) {
            System.out.println("Enter the question "+(i+1)+" : ");
            qu[i][0] = in.nextLine();
            in.nextLine();
            for (int j = 1; j <= 4 ; j++) {
                System.out.println("Enter the option " + j + " : ");
                qu[i][j] = in.nextLine();
                in.nextLine();
            }
            System.out.println("Enter the correct option number : ");
            qu[i][5] = in.nextLine();
        }
        oa[index].quizt(noq,index);
        for(int ol = 0; ol < noq ; ol ++){
            for( int il = 0; il < 6; il ++){
                oa[index].questions[ol][il] = qu[ol][il];
            }
        }
        System.out.println("Successfully created !! \n The quiz code is : "+oa[index].id);
        return 0;
    }
    int reuse(quiz[] oa, teachers[] object_array, int tid, int index){
        System.out.println("Enter the quiz code to be reused : ");
        int ijb = in.nextInt();
        int h = -1;
        int hyuo = teachers_search(tid, object_array);
        for( int i = 0; i < object_array[hyuo].nofq; i++){
            if(ijb == Integer.parseInt(object_array[i].quiz_created[i])){
                h = i;
                break;
            }
            else
                h = -1;
        }
        if(h == -1)
            System.out.println("No such quiz exists !! Check the quiz code you have entered !!");
        else{
            h = quiz_search(ijb, oa);
            for(int y = 0; y < 1000 ; y++){
                if(oa[y].id == h){
                    oa[index] = new quiz();
                    oa[index].quizt(oa[h].noq,(index));
                    for(int k = 0; k < oa[h].noq; k ++){
                        oa[index].questions[k][0] = oa[y].questions[k][0];
                        oa[index].questions[k][1] = oa[y].questions[k][1];
                        oa[index].questions[k][2] = oa[y].questions[k][2];
                        oa[index].questions[k][3] = oa[y].questions[k][3];
                        oa[index].questions[k][4] = oa[y].questions[k][4];
                        oa[index].questions[k][5] = oa[y].questions[k][5];
                    }
                    break;
                }
            }
            System.out.println("Successfully created quiz !! The quiz id is : "+ oa[index].id);
        }
        return 0;
    }
}

class search extends Main{
    int quiz_search(int qid, quiz[] oa){
        int opi = -1;
        for (int i = 0 ; i < total_quiz; i++){
             if (oa[i].id == qid) {
                    opi = i;
                    break;
             }
            else
                opi = -1;
        }
        return opi;
    }
    int student_search(int qid, students[] obar){
        int opi = -1;
        for (int i = 200 ; i < total_students; i++){
                if (obar[i].id == qid) {
                    opi = i;
                    break;
                }
    }
        return opi;
    }
    int teachers_search(int qid, teachers[] object_array){
        int opi = -1;
        for (int i = 100 ; i < total_teachers; i++){
                if (object_array[i].id == qid) {
                    opi = i;
                    break;
                }
            }
        return opi;
    }
    int guest_search(int qid, guest[] oa){
        int opi = -1;
        for (int i = 300 ; i < total_guest; i++){
            if(oa[i].id == qid){
                opi = i;
                break;
            }
        }
        return opi;
    }
    int quizpart_search(int pid, int qid, quiz[] oa){
        int opi = -1;
        int hu = quiz_search(qid,oa);
            for(int j = 0; j <= oa[hu].nop; j++)
            if(Integer.parseInt(oa[hu].participants[j][0]) == pid){
                opi = hu;
                break;
            }
        return opi;
    }
}