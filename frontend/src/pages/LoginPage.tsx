import React from 'react';
import { Twitter } from 'lucide-react';
import { SignupModal } from '../components/SignupModal';
import { LoginModal } from '../components/LoginModal';

interface LoginPageProps {
  onLogin: () => void;
}

export function LoginPage({ onLogin }: LoginPageProps) {
  const [authModal, setAuthModal] = React.useState<{
    isOpen: boolean;
    type: 'login' | 'signup';
  }>({
    isOpen: false,
    type: 'login',
  });

  return (
    <div className="min-h-screen flex bg-white dark:bg-gray-950 transition-colors">
      {/* Left Section */}
      <div className="hidden lg:flex lg:w-1/2 bg-blue-500 dark:bg-blue-600 items-center justify-center">
        <Twitter className="text-white w-96 h-96" />
      </div>

      {/* Right Section */}
      <div className="flex-1 flex flex-col justify-center px-4 sm:px-6 lg:px-20 py-12 sm:py-16">
        <div className="sm:mx-auto sm:w-full sm:max-w-md">
          <Twitter className="w-12 h-12 text-blue-500 dark:text-blue-400 mb-8" />
          <h1 className="text-4xl font-bold mb-8 text-gray-900 dark:text-white">
            Happening now
          </h1>
          <h2 className="text-3xl font-bold mb-8 text-gray-900 dark:text-white">
            Join today.
          </h2>
        </div>

        <div className="sm:mx-auto sm:w-full sm:max-w-md space-y-4">
          <button
            onClick={() => setAuthModal({ isOpen: true, type: 'signup' })}
            className="w-full bg-blue-500 dark:bg-blue-600 text-white rounded-full py-3 font-bold hover:bg-opacity-90 transition-colors"
          >
            Create account
          </button>

          <div className="relative">
            <div className="absolute inset-0 flex items-center">
              <div className="w-full border-t border-gray-300 dark:border-gray-700"></div>
            </div>
            <div className="relative flex justify-center text-sm">
              <span className="px-2 bg-white dark:bg-gray-950 text-gray-500 dark:text-gray-400">
                or
              </span>
            </div>
          </div>

          {/* Google Sign In Button */}
          <button
            onClick={() => console.log('Sign in with Google')}
            className="w-full border border-gray-300 dark:border-gray-700 text-gray-800 dark:text-gray-100 bg-white dark:bg-gray-800 rounded-full py-3 font-bold hover:bg-gray-100 dark:hover:bg-gray-700 transition-colors flex items-center justify-center space-x-2"
          >
            <img
              src="https://www.svgrepo.com/show/475656/google-color.svg"
              alt="Google"
              className="w-5 h-5"
            />
            <span>Sign in with Google</span>
          </button>

          <div className="relative">
            <div className="absolute inset-0 flex items-center">
              <div className="w-full border-t border-gray-300 dark:border-gray-700"></div>
            </div>
            <div className="relative flex justify-center text-sm">
              <span className="px-2 bg-white dark:bg-gray-950 text-gray-500 dark:text-gray-400">
                or
              </span>
            </div>
          </div>

          <button
            onClick={() => setAuthModal({ isOpen: true, type: 'login' })}
            className="w-full border border-gray-300 dark:border-gray-700 text-blue-500 dark:text-blue-400 rounded-full py-3 font-bold hover:bg-gray-50 dark:hover:bg-gray-800 transition-colors"
          >
            Sign in
          </button>
        </div>
      </div>

      {authModal.type === 'signup' ? (
        <SignupModal
          isOpen={authModal.isOpen}
          onClose={() => setAuthModal({ ...authModal, isOpen: false })}
        />
      ) : (
        <LoginModal
          isOpen={authModal.isOpen}
          onClose={() => setAuthModal({ ...authModal, isOpen: false })}
          onLogin={onLogin}
        />
      )}
    </div>
  );
}
