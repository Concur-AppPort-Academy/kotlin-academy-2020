import UIKit
import app

class ViewController: UIViewController {
    override func viewDidLoad() {
        super.viewDidLoad()
        label.text = Proxy().proxyHello()
        
        
        NetworkClient().getHelloWorld { result in
            print("Result: \(result)")
        }

        NetworkClient().getExpenses { result in
            print("Result: \(result)")
        }        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    @IBOutlet weak var label: UILabel!
}
