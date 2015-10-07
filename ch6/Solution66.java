package ch6.cbc.xuewei.ece.cmu;

public class Solution66 {

	public static void main(String[] args) {
		/*
		 * Assume there are n people on the island, among which there are b people having blue eyes.
		 * 
		 * If b = 1: because each person can see everyone else's eye color, the one who has blue eyes 
		 * would figure out he is the only one who has blue eyes after seeing that all others have normal
		 * eyes. So he would take the flight the first evening. 
		 * 
		 * If b = 2: assume the two guys are A and B. So A and B knows that there are each other who has blue
		 * eyes on the island, but they don't know themselves also have blue eyes. So they would stay in 
		 * the island the first evening. But the next day, they would see each other still on the island. 
		 * So they know b is 2 rather than 1. And as they see that the rest people on the island all have 
		 * normal eyes, they know themselves are the other guy who has blue eyes, so they would leave 
		 * the island the second evening.
		 * 
		 * If b > 2: Similar with the case b = 2, if b = 3, no one would leave the island until the 3rd evening
		 * when they find b = 3 and all others have normal eyes. This same pattern extends up through any larger
		 * value of b. So if there are b people have blues eyes, they will leave the island on the bth everning.
		 * Namely it takes b days for the blue-eyed people to leave.
		 * 
		 */

	}

}
