function animal(name,energy){
    let animal = {}
    animal.name = name
    animal.energy = energy

    animal.eat = function (amount){
        console.log(`${this.name} is here`)
        this.energy += amount
    }
    
    animal.sleep = function (length){
        console.log(`${this.name} is here`)
        this.energy += length
    }
    
    animal.play = function (length){
        console.log(`${this.name} is here`)
        this.energy -= length
    }
    return animal
}