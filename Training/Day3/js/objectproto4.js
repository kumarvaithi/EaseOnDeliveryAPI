
class Animal{
    constructor(name,energy){
        this.name = name;
        this.energy = energy;
    }
    
    eat(amount){
        console.log(`${this.name} is here`)
        this.energy += amount
    }
    sleep(length){
        console.log(`${this.name} is here`)
        this.energy += length
    }
    play(length){
        console.log(`${this.name} is here`)
        this.energy -= length
    }   
}

const leo = new Animal("leo",10)