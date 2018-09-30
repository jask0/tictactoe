import java.util.Scanner;


public class Xxo {
	public static String[][] field = {{"7","8","9"},{"4","5","6"},{"1","2","3"}};
	public static Scanner sc = new Scanner(System.in);
	public static String[] players = {"O","X"};
	public static String player = "";
	public static int play = 1;
	
	public static void pretty_print_field(){
		for(int i=0; i<field.length;i++){
			System.out.println(String.format("'%s'\t'%s'\t'%s'", field[i][0], field[i][1], field[i][2]));
		}
	}
	
	public static String get_position(String player){
		System.out.println(String.format("Player '%s' choose your position!", player));
		String position = sc.nextLine();
		return position;
	}
	public static boolean set_on_field(String position,  String player){
		for(int i=0; i<field.length;i++){
			for(int j=0; j<field.length;j++){
				if(position.equals(field[i][j])){
					field[i][j] = player;
					return true;
				}
			}
		}
		return false;
	}
	public static boolean is_winner(){
		if((field[0][0].equals(field[1][1])) && (field[1][1].equals(field[2][2])))
	        return true;
	    if((field[0][2].equals(field[1][1])) && (field[1][1].equals(field[2][0])))
	        return true;
	    for(int i=0; i<field.length;i++){
	        if((field[i][0].equals(field[i][1])) && (field[i][1].equals(field[i][2])))
	            return true;
	        if ((field[0][i].equals(field[1][i])) && (field[1][i].equals(field[2][i])))
	            return true;
	    }
		return false;
	}
	
	public static void main(String[] args){
		while(play>0){
			player = players[play%2];
			pretty_print_field();
	        while(true){
	        	String position = get_position(player);
	            if(set_on_field(position, player)){
	            	break;
	            }else{
	            	System.out.println("The position is already set, please choose another one!");
	                pretty_print_field();
	            	
	            }
	        }
	    play = is_winner() ? 0 : play+1;
		}
	pretty_print_field();
	System.out.println(String.format("Congrats player '%s' is the winner!", player));
	sc.close();
	}
}
