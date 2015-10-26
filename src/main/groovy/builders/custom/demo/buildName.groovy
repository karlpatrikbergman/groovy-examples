package builders.custom.demo


new DemoBuilder().build {
    household(adress: "main street 42") {
        car("VW", 15000)
    }
}