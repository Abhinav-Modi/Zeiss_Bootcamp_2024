using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BugFixTaskManager
{
    public interface IScanner { void Scan(string path); }
    public class Scanner: IScanner
    {

        public void Scan(string path)
        {
            System.Console.WriteLine($"Scanning .....{path}");
        }
    }
}
