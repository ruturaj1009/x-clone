import React from 'react';
import { Check } from 'lucide-react';

interface PlanFeature {
  included: boolean;
  text: string;
}

interface Plan {
  name: string;
  price: string;
  description: string;
  features: PlanFeature[];
  buttonText: string;
  recommended?: boolean;
}

export function SubscriptionPage() {
  const plans: Plan[] = [
    {
      name: 'Basic',
      price: '$8',
      description: 'Perfect for casual users',
      features: [
        { included: true, text: 'Ad-free experience' },
        { included: true, text: 'Basic analytics' },
        { included: true, text: 'Standard support' },
        { included: false, text: 'Verified checkmark' },
        { included: false, text: 'Priority ranking' },
      ],
      buttonText: 'Start Basic',
    },
    {
      name: 'Premium',
      price: '$16',
      description: 'Best for power users',
      features: [
        { included: true, text: 'Ad-free experience' },
        { included: true, text: 'Advanced analytics' },
        { included: true, text: 'Priority support' },
        { included: true, text: 'Verified checkmark' },
        { included: true, text: 'Priority ranking' },
      ],
      buttonText: 'Start Premium',
      recommended: true,
    },
    {
      name: 'Business',
      price: '$32',
      description: 'For organizations and teams',
      features: [
        { included: true, text: 'Ad-free experience' },
        { included: true, text: 'Enterprise analytics' },
        { included: true, text: '24/7 support' },
        { included: true, text: 'Verified checkmark' },
        { included: true, text: 'Top ranking priority' },
      ],
      buttonText: 'Start Business',
    },
  ];

  const handleSubscribe = (planName: string) => {
    console.log(`Subscribing to ${planName} plan`);
    // Handle subscription logic here
  };

  return (
    <div className="min-h-screen border-x border-gray-200">
      <div className="sticky top-0 bg-white border-b border-gray-200 p-4">
        <h1 className="text-xl font-bold">Subscribe to Premium</h1>
      </div>
      
      <div className="p-4">
        <div className="text-center mb-8">
          <h2 className="text-2xl font-bold mb-2">Choose your plan</h2>
          <p className="text-gray-600">Select the perfect plan for your needs</p>
        </div>

        <div className="grid md:grid-cols-3 gap-8 max-w-6xl mx-auto">
          {plans.map((plan) => (
            <div
              key={plan.name}
              className={`relative rounded-2xl border ${
                plan.recommended
                  ? 'border-blue-500 shadow-lg'
                  : 'border-gray-200'
              } p-6`}
            >
              {plan.recommended && (
                <div className="absolute -top-4 left-1/2 transform -translate-x-1/2">
                  <span className="bg-blue-500 text-white px-4 py-1 rounded-full text-sm">
                    Recommended
                  </span>
                </div>
              )}
              
              <div className="text-center mb-6">
                <h3 className="text-lg font-bold mb-2">{plan.name}</h3>
                <div className="text-3xl font-bold mb-2">
                  {plan.price}
                  <span className="text-gray-500 text-base font-normal">/month</span>
                </div>
                <p className="text-gray-600">{plan.description}</p>
              </div>

              <ul className="space-y-4 mb-6">
                {plan.features.map((feature, index) => (
                  <li key={index} className="flex items-center">
                    <Check
                      size={20}
                      className={feature.included ? 'text-blue-500' : 'text-gray-300'}
                    />
                    <span className={`ml-2 ${feature.included ? 'text-gray-900' : 'text-gray-400'}`}>
                      {feature.text}
                    </span>
                  </li>
                ))}
              </ul>

              <button
                onClick={() => handleSubscribe(plan.name)}
                className={`w-full py-2 px-4 rounded-full font-bold ${
                  plan.recommended
                    ? 'bg-blue-500 text-white hover:bg-blue-600'
                    : 'border border-blue-500 text-blue-500 hover:bg-blue-50'
                } transition-colors`}
              >
                {plan.buttonText}
              </button>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}