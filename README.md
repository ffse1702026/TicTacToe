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
    
    
    
    import React, {Component} from 'react';

export default class PromiseComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {msg: "Hello"};
    }
    onChange= (event) => {
        console.log(event);
        this.setState({msg: event.target.value})
    }
    getMessage= () => {
        return this.state.msg
    }
    getMessageD = () => {
        return this.state.msg.split('').reverse().join('')
    }
    shouldComponentUpdate() {
        this.openFile()
        this.setState({msg: "Hello"});
        return true;
    }

    openFile = () =>{
        console.log('open file');
    }
   
    render() {
        return (
            <div>
                <span>{ this.getMessage()}</span>
                <input value={this.state.msg}  onChange={(text) => this.onChange(text)}/>
                <span>{ this.getMessageD()}</span>
            </div>
        );
    }

    
}
