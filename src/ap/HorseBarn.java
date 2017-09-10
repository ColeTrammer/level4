package ap;

public class HorseBarn {

	/** The spaces in the barn. Each array element holds a reference to the horse
	 * that is currently occupying the space. A null value indicates an empty space.
	 */
	 private Horse[] spaces;
	 /** Returns the index of the space that contains the horse with the specified name.
	 * Precondition: No two horses in the barn have the same name.
	 * @param name the name of the horse to find
	 * @return the index of the space containing the horse with the specified name;
	 * -1 if no horse with the specified name is in the barn.
	 */
	 public int findHorseSpace(String name)
	 { 
		 for (int i = 0; i < spaces.length; i++) {
			 if (spaces[i] != null && spaces[i].getName().equals(name)) {
				 return i;
			 }
		 }
		 return -1;
	 }
	 /** Consolidates the barn by moving horses so that the horses are in adjacent spaces,
	 * starting at index 0, with no empty space between any two horses.
	 * Postcondition: The order of the horses is the same as before the consolidation.
	 */
	 public void consolidate()
	 { 
		 //Horse[] newSpaces = 
		 for (int i = 0; i < spaces.length; i++) {
			 
		 }
	 }
	 // There may be instance variables, constructors, and methods that are not shown. 
	public Horse[] getSpaces() {
		return spaces;
	}
	public void setSpaces(Horse[] spaces) {
		this.spaces = spaces;
	}
	public static HorseBarn createTestBarn() {
		HorseBarn horseBarn = new HorseBarn();
		Horse[] spaces = { 
				new Horse("Trigger", 1340), 
				null,
				new Horse("Silver", 1210),
				new Horse("Lady", 1575),
				null,
				new Horse("Patches", 1350),
				new Horse("Duke", 1410)
		};
		horseBarn.setSpaces(spaces);
		return horseBarn;
	}
	
}
