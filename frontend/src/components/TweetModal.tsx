import React from 'react';
import { Image, Smile, Calendar, MapPin, X } from 'lucide-react';
import { TweetModalProps } from '../types';

export function TweetModal({ isOpen, onClose }: TweetModalProps) {
  const [tweet, setTweet] = React.useState('');
  const [isSubmitting, setIsSubmitting] = React.useState(false);

  if (!isOpen) return null;

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    if (!tweet.trim()) return;

    setIsSubmitting(true);
    // Simulate API call
    await new Promise(resolve => setTimeout(resolve, 1000));
    setIsSubmitting(false);
    setTweet('');
    onClose();
  };

  return (
    <div className="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center z-50 p-4">
      <div className="bg-white dark:bg-gray-900 rounded-2xl w-full max-w-xl">
        <div className="flex items-center justify-between p-4 border-b border-gray-200 dark:border-gray-700">
          <button onClick={onClose} className="p-2 hover:bg-gray-100 dark:hover:bg-gray-800 rounded-full">
            <X size={20} className="text-gray-800 dark:text-gray-200" />
          </button>
          <button
            onClick={handleSubmit}
            disabled={!tweet.trim() || isSubmitting}
            className="bg-blue-500 text-white rounded-full px-4 py-1.5 font-bold hover:bg-blue-600 transition-colors disabled:opacity-50"
          >
            {isSubmitting ? 'Posting...' : 'Tweet'}
          </button>
        </div>
        <div className="p-4">
          <div className="flex space-x-4">
            <img
              src="https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?ixlib=rb-1.2.1&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80"
              alt="Your avatar"
              className="h-12 w-12 rounded-full"
            />
            <div className="flex-1">
              <textarea
                value={tweet}
                onChange={(e) => setTweet(e.target.value)}
                placeholder="What's happening?"
                className="w-full resize-none outline-none mb-4 min-h-[150px] text-xl bg-transparent text-gray-900 dark:text-gray-100 placeholder-gray-500 dark:placeholder-gray-400"
                autoFocus
              />
              <div className="flex items-center justify-between border-t pt-4 border-gray-200 dark:border-gray-700">
                <div className="flex space-x-2">
                  <button className="p-2 hover:bg-blue-50 dark:hover:bg-gray-800 rounded-full text-blue-500">
                    <Image size={20} />
                  </button>
                  <button className="p-2 hover:bg-blue-50 dark:hover:bg-gray-800 rounded-full text-blue-500">
                    <Smile size={20} />
                  </button>
                  <button className="p-2 hover:bg-blue-50 dark:hover:bg-gray-800 rounded-full text-blue-500">
                    <Calendar size={20} />
                  </button>
                  <button className="p-2 hover:bg-blue-50 dark:hover:bg-gray-800 rounded-full text-blue-500">
                    <MapPin size={20} />
                  </button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
