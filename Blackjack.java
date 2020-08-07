import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
public class Blackjack {
	public static void main(String[] args) {

		int card1_user = (int)(Math.random() * 10) + 2;
		int card2_user = (int)(Math.random() * 10) + 2;

		int card1_dealer = (int)(Math.random() * 10) + 2;
		int card2_dealer = (int)(Math.random() * 10) + 2;

		String user_cards = Integer.toString(card1_user) + " " + Integer.toString(card2_user);
		String dealer_cards = Integer.toString(card1_dealer) + " " + Integer.toString(card2_dealer);
		
		int sum1 = card1_user + card2_user, sum2 =card1_dealer + card2_dealer;

		int end_user = 0;
		int end_dealer = 0;

		if (sum1 > 21) {
			end_user = 1;
		}

		else if (sum2 > 21) {
			end_dealer = 1;
		}

		while (sum1 <= 21) {

			System.out.println("You have " + user_cards);

			System.out.println("Do you want to 'hit' or 'stand' ? ");

			Scanner input = new Scanner(System.in);

			String answer = input.nextLine();

			
			if (answer.equals ("hit")) {

				int card_user = (int)(Math.random() * 10) + 2;


				ImageIcon icon = new ImageIcon("edu/nyu/cs/yj1351/" + card_user + ".jpg");
        		JOptionPane.showMessageDialog(null, "You got", 
                "Blackjack", JOptionPane.INFORMATION_MESSAGE, icon);
				
				sum1 += card_user;
				user_cards += " " + Integer.toString(card_user);
				
				if (sum1 > 21) {
					end_user = 1;
					break;
				}

				else {
					continue;
				}
				

			}

			else if (answer.equals ("stand") || answer.equals ("stop") || answer.equals ("pass")) {
				break;
			}

			else {
				System.out.println("Invalid entry. Please try again!");
			}
		}


		while (sum2 <= 21 && sum1 <= 21) {

			int dealer_choice = (int)(Math.random() * 2);

					if (dealer_choice == 1) {

						int card_dealer = (int)(Math.random() * 10) + 2;
						sum2 += card_dealer;
						dealer_cards += " " + Integer.toString(card_dealer);
				
						if (sum2 > 21) {
							end_dealer = 1;
							break;
						}
					}

					else {
						break;
					}
		}

		if (end_user == 1) {
			System.out.println("You are busted! The dealer wins. You got " + sum1 + " in total, and the dealer got " + sum2 + " in total.");
			System.out.println("You lose with " + user_cards + ", and the dealer wins with " + dealer_cards);
		}

		else if (end_dealer == 1) {
			System.out.println("The dealer is busted! You win. You got " + sum1 + " in total, and the dealer got " + sum2 + " in total.");
			System.out.println("The dealer loses with " + dealer_cards + ", and you win with " + user_cards);
		}

		else {
			if (sum1 > sum2) {
				System.out.println("You have " + user_cards + ", and the dealer has " + dealer_cards);
				System.out.println("You got " + sum1 + " in total, and the dealer got " + sum2 + " in total.");
				System.out.println("You win.");
			}

			else if (sum1 < sum2) {
				System.out.println("You have " + user_cards + ", and the dealer has " + dealer_cards);
				System.out.println("You got " + sum1 + " in total, and the dealer got " + sum2 + " in total.");
				System.out.println("The dealer wins.");
			}

			else {
				System.out.println("You have " + user_cards + ", and the dealer has " + dealer_cards);
				System.out.println("You got " + sum1 + " in total, and the dealer got " + sum2 + " in total.");
				System.out.println("It's a tie.");
			}

		}
	}
}















