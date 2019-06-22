
function Animal(name,energy){
    // let animal = Object.create(Animal.prototype)
    
    this.name = name;
    this.energy = energy;
    // animal.name = name
    // animal.energy = energy
    // return animal
}

Animal.prototype.eat = function (amount){
    console.log(`${this.name} is here`)
    this.energy += amount
}

Animal.prototype.sleep = function (length){
    console.log(`${this.name} is here`)
    this.energy += length
}

Animal.prototype.play = function (length){
    console.log(`${this.name} is here`)
    this.energy -= length
}

// const leo = Animal("leo",10)
const leo = new Animal("leo",10)
