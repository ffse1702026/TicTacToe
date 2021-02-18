## TicTacToe

### Description
Tic tac toe game on 5x5 board. Written in Java using JavaFX for GUI and minimax algorithm with alpha beta pruning for computer moves

### Requirements
* JDK >= 1.8
  
### How to build
Launch commands below from this directory
#### Windows
    gradlew.bat jfxJar
    java -jar  ./build/jfx/app/TicTacToe.jar

#### Linux & MacOS
    ./gradlew jfxJar
    java -jar  ./build/jfx/app/TicTacToe.jar
    
    
    
<!DOCTYPE html>
<html>
<body>

<h2>JavaScript</h2>


</body>
<script>

let object1 = {1 : {2 : {"t" : 1, "b": 2, 3 : {4 : 5, 6: 7, 8: 9}}}}

let object2 = {1 : {2 : { "b": 5, 3 : {4 : 10, 6: 11, 8: 12}}}}



function compareObject(object1, object2) {

		Object.keys(object2).forEach(function(key) {
		if(object1[key] && object2[key] && typeof object2[key] ===  'object'){
			console.log('if', object2[key])
			compareObject(object1[key], object2[key])
			
		} else if(object1[key] && object2[key]){
			console.log('else')
			object1[key] = object2[key];
		}
			
		});
	
}

compareObject(object1, object2);

console.log(object1)

</script>
</html> 
