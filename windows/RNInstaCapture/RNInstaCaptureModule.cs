using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Com.Reactlibrary.RNInstaCapture
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNInstaCaptureModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNInstaCaptureModule"/>.
        /// </summary>
        internal RNInstaCaptureModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNInstaCapture";
            }
        }
    }
}
