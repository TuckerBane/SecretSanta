import java.util.*;
import java.io.*;
//import java.lang.String;

public class JavaProgram {
	
	private static List<String> FindLongestList(List< List< String > > groupedNames){
		int longestLenth = 0;
		List<String> longestList = new Vector<String>();
		for(List<String> group : groupedNames){
			if(group.size() > longestLenth){
				longestLenth = group.size();
				longestList = group;
			}
		}
		return longestList;
	}

	private static List<String> SecretSantaInsertShuffle(List<String> ungroupedNames, List< List< String> > groupedNames ) {
		// shuffle and make sure we're using groups
		List<String> result = new Vector<String>();
		Collections.shuffle(ungroupedNames);
		if(groupedNames.size() == 0){
			return ungroupedNames;
		}
		// seperate out the largest group
		List<String> longestList = FindLongestList(groupedNames);
		groupedNames.remove(longestList);
		Collections.shuffle(groupedNames);
		// prep a list for each member of the largest group
		Vector<Vector<String> > peopleSlots = new Vector<Vector<String> >();
		for(String s : longestList){
			peopleSlots.add( new Vector<String>() );
		}
		// cycle through the groups adding everyone else to them
		int currentGroupInsertIndex = 0;
		for(List<String> group : groupedNames){
			for(String s : group){
				peopleSlots.elementAt(currentGroupInsertIndex).add(s);
				++currentGroupInsertIndex;
				if(currentGroupInsertIndex >= peopleSlots.size())
					currentGroupInsertIndex = 0;
			}
		}
		for(String s : ungroupedNames){
				peopleSlots.elementAt(currentGroupInsertIndex).add(s);
				++currentGroupInsertIndex;
				if(currentGroupInsertIndex >= peopleSlots.size())
					currentGroupInsertIndex = 0;
		}
		// stick a person from the largest group on the end of each group to keep the original groups from giving gifts to each other
		Collections.shuffle(longestList);
		System.out.println(longestList);
		for(int i = 0; i < peopleSlots.size(); ++i){
			Collections.shuffle(peopleSlots.elementAt(i));
			peopleSlots.elementAt(i).add(longestList.get(i));
		}
		// combine all the mini-lists into our final list
		for(Vector<String> group : peopleSlots){
			result.addAll(group);
		}
		// display a version broken into groups for visual clerity
		System.out.println(peopleSlots);
		System.out.println(result);
		return result;		
	}
	
    public static void main(String args[]) {
        List<String> inputNames = new Vector<String>();
        Scanner in = new Scanner(System.in);
        String newName = new String();
		System.out.println("Enter names, or quit to move on");
        do
        {
            newName = in.next();
			inputNames.add(newName);
        }while( !newName.equals("quit") );
		inputNames.remove(inputNames.indexOf("quit"));
		Collections.shuffle(inputNames);
        int x=10;
        int y=25;
        int z=x+y;
		System.out.println(inputNames);
        System.out.println("Sum of x+y = " + z);

		SecretSantaInsertShuffle(inputNames, new ArrayList<>(  List.of( new ArrayList<>( List.of("aa","bb") ), new ArrayList<>( List.of("cc","dd","ee") ) ) )   );

		newName = in.next();
    }
}