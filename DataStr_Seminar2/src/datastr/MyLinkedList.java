package datastr;

public class MyLinkedList<T> {

	private MyListNode first = null; // norāde jeb saite uz pirmo bloku
	private MyListNode last = null; // norāde jeb saite uz pēdējo bloku
	private int counter = 0;

	// tiks izmantots noklusētais Object konstruktors

	public boolean isEmpty() {
		return (counter == 0);
	}

	public boolean isFull() {
		boolean result = false;

		try {
			MyListNode newNode = new MyListNode<T>((T) new Object());
		} catch (OutOfMemoryError e) {
			result = true;
		}

		return result;
	}

	public int howManyElements() {
		return counter;
	}

	public int howManyElementsAlgorithm() {
		int result = 0;

		MyListNode<T> temp = first;

		while (temp != null) {
			temp = temp.getNext();
			result++;
		}

		return result;
	}

	public void add(T element) {

		// jaunais mezgls būs pats pirmais sarakstā
		if (isEmpty()) {
			MyListNode newNode = new MyListNode(element);
			first = newNode;
			last = newNode;
		}
		// nebūš pirmais, bet kārtējais
		else {
			MyListNode newNode = new MyListNode(element);
			last.setNext(newNode);
			newNode.setPrevious(last);
			last = newNode;

		}
		counter++;

	}

	public void add(int place, T element) throws Exception {

		if (place < 0 || place > counter) {
			throw (new Exception("Incorecct place"));
		}

		if (isEmpty()) {
			add(element);
		}

		// 1. ja gribat ielikt priekšā
		if (place == 0) {
			MyListNode newNode = new MyListNode(element);
			first.setPrevious(newNode);
			newNode.setNext(first);
			first = newNode;

			counter++;
		}
		// 2, ja gribam beigās pievienot
		else if (place == counter) {

		}
		// 3. ja grib vidū pievienot
		else {
			MyListNode temp = first;
			for (int i = 0; i < place - 1; i++) {
				temp = temp.getNext();
			}
			MyListNode leftNode = temp; // noskaidro kas jaunajm blokam bus labajaa un kreisaja pusee
			MyListNode rightNode = temp.getNext();
			MyListNode newNode = new MyListNode(element); // izveido pasu bloku
			leftNode.setNext(newNode); // izveido saites
			newNode.setPrevious(leftNode);

			rightNode.setPrevious(newNode);
			newNode.setNext(rightNode);

			counter++;
		}

	}

	public void print() {

		MyListNode temp = first;

		for (int i = 0; i < counter; i++) {
			System.out.print(temp.getElement() + " ");
			temp = temp.getNext();
		}
		System.out.println();
	}
	
	public int[] search(T element) throws Exception {
        
        int howMany = 0;
        
        MyListNode temp = first;
        
        for(int i = 0; i < counter; i++) {
                if(temp.getElement().equals(element))
                {
                        howMany++;
                }
                
                temp = temp.getNext();        
        }
        
        if(howMany == 0) throw new Exception("Element is not found");
        
        
        int[] places = new int[howMany];
        temp = first;
        int counterForPlaces = 0;
        for(int i = 0; i < counter; i++) {
                if(temp.getElement().equals(element))
                {
                        places[counterForPlaces] = i;
                        counterForPlaces++;
                }
                
                temp = temp.getNext();        
        }
        
        return places;
        
}

	public void remove(int place) throws Exception {
		
		if (isEmpty()) throw (new Exception("List is empty and it is not possible to remove")); 
		
		if (place < 0 || place > counter) {
			throw (new Exception("Incorrect place"));
		}
		
		if (counter == 1 ) {
			first = null;
			last = null;
			System.gc();
			counter--;
		}
		else {
			// ja tiek izments pirmais
			if(place == 0 ) {
				MyListNode removedNode = first;
				MyListNode whoWillBeFirst = removedNode.getNext();
				whoWillBeFirst.setPrevious(null);
				first = whoWillBeFirst;
				System.gc();
				counter--;
				
			}
			//ja tiek iznemts pedejeias
			else if(place == counter-1) {
				MyListNode removedNode = last;
				MyListNode whoWillBeLast = removedNode.getPrevious();
				whoWillBeLast.setNext(null);
				last = whoWillBeLast;
				System.gc();
				counter--;
				
			}
			// ja tiek iznemts kads pa vidu
			else{
				 MyListNode temp = first;
				 for(int i = 0; i < place; i++) {
					 temp = temp.getNext();
				 }
				 MyListNode leftNode = temp.getPrevious();
				 MyListNode rightNode = temp.getNext();
				 
				 leftNode.setNext(rightNode);
				 rightNode.setPrevious(leftNode);
				 
				 System.gc();
				 counter--;
				 
			}
		}
	}
	//Izveidot funkicju, kas veic elementa izgūsanu pec kartas nr
	public T get(int place) throws Exception {
		//is empty parbaude
		if (isEmpty()) throw (new Exception("List is empty")); 
		//place parbaude
		if (place < 0 || counter <= place) {
			throw (new Exception("Incorrectplace"));
		}
		//veikt ar for ciklu lēkšanu jeb temp = temp.getNext();
		MyListNode temp = first;
		for(int i = 0; i < place; i++) {
			temp = temp.getNext();
		}
		// atgriezt temp vērtība (nevis viss bloks jeb node)
		return (T) temp.getElement();
	}
	//izveidot funkciju , kas veic saraksta iztulkošanu
	public void makeEmpty() {
		counter = 0;
		last = null;
		first = null;
		System.gc(); 
		
	}

}


