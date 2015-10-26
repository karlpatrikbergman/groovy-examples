package builders.custom.demo


new DemoBuilder().build {
    household(adress: "main street 42") {
        car(name: "VW", price: 15000)
        room {
            name("living room")
            furniture(name: "TV", price: 2000)
            furniture(name: "sofa", price: 1000)
        }
    }
}
