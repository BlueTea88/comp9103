public class Q4_RockPaperScissors
{
	public static void main(String[] args)
	{
		// Generate uniform random variables between -0.5 and 2.5, then round to nearest integer
		int machine_index = (int) Math.round(Math.random() * 3.0 - 0.5);
		
		// Convert machine selection into String
		String[] machine_map = {"scissor","rock","paper"};
		String machine_select = machine_map[machine_index];
		System.out.println("Machine selected: " + machine_select);
		
		// Only continue if user inputs are valid
		if (args[0].equalsIgnoreCase("scissor") || args[0].equalsIgnoreCase("rock") || args[0].equalsIgnoreCase("paper")) {
			// Draw condition
			if (args[0].equalsIgnoreCase(machine_select)) {
				System.out.println("Its a draw.");
			
			// Go through remaining possibilities depending on user selection
			} else if (args[0].equalsIgnoreCase("scissor")){
				switch(machine_select){
					case "paper": System.out.println("You win!"); break;
					case "rock": System.out.println("You lose..."); break;
					default: break;
				}
			} else if (args[0].equalsIgnoreCase("rock")){
				switch(machine_select){
					case "scissor": System.out.println("You win!"); break;
					case "paper": System.out.println("You lose..."); break;
					default: break;
				}
			} else if (args[0].equalsIgnoreCase("paper")){
				switch(machine_select){
					case "rock": System.out.println("You win!"); break;
					case "scissor": System.out.println("You lose..."); break;
					default: break;
				}
			}
		} else {
			System.out.println("Please select a valid input: scissor, rock or paper.");
		}
	}
}
