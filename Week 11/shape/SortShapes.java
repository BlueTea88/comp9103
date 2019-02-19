import java.util.ArrayList;

public class SortShapes {
	
	private ArrayList<Shape> shapes;
	
	public SortShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}
	
	/**
		Sort by area.
	*/
	public void sortArea() {
		this.sort("area");
	}
	
	/**
		Sort by perimeter.
	*/
	public void sortPerimeter() {
		this.sort("perimeter");
	}
	
	/**
		Sort by a specified comparison field.
		@param field comparison field name ("area" or "perimeter")
	*/
	public void sort(String field) {
		ArrayList<Shape> sortedShapes = new ArrayList<Shape>();
		Shape current;
		double currentValue;
		double comparisonValue;
		
		for (int i = 0; i < shapes.size(); i++) {
			// Current shape details
			current = shapes.get(i);
			
			if (field.equals("area")) {
				currentValue = current.area();
			} else {
				currentValue = current.perimeter();
			}
			
			// Just place the first shape in the sorted list
			if (i == 0) {
				sortedShapes.add(current);
				continue;  // skip to next shape
			}
			
			// Otherwise, compare the value of the current shape with those in the sorted list
			for (int j = 0; j < sortedShapes.size(); j++) {
				// Comparison shape values
				if (field.equals("area")) {
					comparisonValue = sortedShapes.get(j).area();
				} else {
					comparisonValue = sortedShapes.get(j).perimeter();
				}
				
				if (currentValue < comparisonValue) {
					sortedShapes.add(j, current);
					break;
				}
				
				// Add shape to end of sorted list if compared value is greater than all sorted shapes
				if (j == sortedShapes.size() - 1) {
					sortedShapes.add(current);
					break;
				}
			}
		}
		
		// Update list
		this.shapes = sortedShapes;
	}
	
	
	/**
		Create a string containing all the details of all shapes in order of their list position.
	*/
	public String toString() {
		String out = "";
		
		for (int i = 0; i < shapes.size(); i++) {
			out = out + shapes.get(i) + "\r\n";
		}
		return out;
	}
}
