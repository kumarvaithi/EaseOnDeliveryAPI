const animalMethods = {
    eat(amount){
        console.log(`${this.name} is here`)
        this.energy += amount
    },
    sleep(length){
        console.log(`${this.name} is here`)
        this.energy += length
    },
    play(length){
        console.log(`${this.name} is here`)
        this.energy -= length
    }
}

function animal(name,energy){
    let animal = Object.create(animalMethods)
    // let animal = {}
    animal.name = name
    animal.energy = energy
    // animal.eat = animalMethods.eat;
    // animal.sleep = animalMethods.sleep;
    // animal.play = animalMethods.play;
    return animal
}