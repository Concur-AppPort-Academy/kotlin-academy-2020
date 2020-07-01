import UIKit
import app

class ViewController: UIViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
                
        NetworkClient().callHelloWorld {result in
            print("\(result) \n")
        }
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    @IBOutlet weak var label: UILabel!
}
