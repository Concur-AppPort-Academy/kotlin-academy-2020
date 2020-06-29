import UIKit
import app

class ViewController: UIViewController {
    override func viewDidLoad() {
        super.viewDidLoad()
        label.text = Proxy().proxyHello()
        
        
        
        
        let teacher = Teacher(name: "John", surname: "Smith")
        print("\(teacher)")
        
        let person = Person()
        person.name = "Mark"
        person.surname = "Doe"
        
        print("Name: \(person.name) and surname: \(person.surname)")
        print("\(person)")
        
        let client = NetworkClient()
        client.getHelloWorld { result in
            print("Result: \(result)")
        }

        client.getExpenses { result in
            print("Result: \(result)")
        }
        
        
        
        
        
        
        
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    @IBOutlet weak var label: UILabel!
}
